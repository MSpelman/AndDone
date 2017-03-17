package com.example.anddone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anddone.TodoTabFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a schedule item and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TodoTabRecyclerViewAdapter extends RecyclerView.Adapter<TodoTabRecyclerViewAdapter.ViewHolder> {

    private final List<IScheduleItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public TodoTabRecyclerViewAdapter(List<IScheduleItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_todo_tab, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTimeView.setText(mValues.get(position).getTime());
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mDescriptionView.setText(mValues.get(position).getDescription());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTimeView;
        public final TextView mNameView;
        public final TextView mDescriptionView;
        public IScheduleItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTimeView = (TextView) view.findViewById(R.id.time);
            mNameView = (TextView) view.findViewById(R.id.name);
            mDescriptionView = (TextView) view.findViewById(R.id.description);
        }

        @Override
        public String toString() {
            return " '" + mDescriptionView.getText() + "'";
        }
    }
}
