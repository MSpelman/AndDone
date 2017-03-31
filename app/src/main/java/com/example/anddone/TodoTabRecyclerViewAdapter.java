package com.example.anddone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.view.ContextMenu;

import com.example.anddone.TodoTabFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a schedule item and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class TodoTabRecyclerViewAdapter extends RecyclerView.Adapter<TodoTabRecyclerViewAdapter.ViewHolder> {

    private final List<IScheduleItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final TodoTabFragment fragment;
    private final Activity activity;
    private AdapterView.AdapterContextMenuInfo menuInfo;

    public TodoTabRecyclerViewAdapter(List<IScheduleItem> items,
                                      OnListFragmentInteractionListener listener,
                                      TodoTabFragment fragment,
                                      Activity activity) {
        mValues = items;
        mListener = listener;
        this.fragment = fragment;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_todo_tab, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        AttributeSet attributes;
        holder.mItem = mValues.get(position);
        holder.mTimeView.setText(mValues.get(position).getTime());
        holder.mTimeView.setId(position);
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mNameView.setId(position);
        holder.mRow.setId(position);
        String name = mValues.get(position).getName();

        fragment.registerForContextMenu(holder.mView);
        menuInfo = new AdapterView.AdapterContextMenuInfo(holder.mView, position, holder.mView.getId());

        // Color coordinate text based on type
        String itemClass = holder.mItem.getClass().toString();
        if (itemClass.contains("Event")) {
            holder.mNameView.setTextColor(Color.MAGENTA);
        } else {
            Task item = (Task) holder.mItem;
            if (item.isCompleted()) {
                holder.mNameView.setTextColor(Color.BLACK);
            } else {
                holder.mNameView.setTextColor(Color.BLUE);
            }
        }

        // Set background color of subheadings and alternating rows
        if (name.equals("Today") || name.equals("Tomorrow")) {
            holder.mRow.setBackgroundColor(Color.BLACK);
            holder.mNameView.setTextColor(Color.WHITE);
            holder.mButtonView.setVisibility(View.VISIBLE);
            holder.mButtonView.setEnabled(true);
        } else if ((position % 2) == 0) {
            holder.mRow.setBackgroundColor(Color.WHITE);
        } else {
            holder.mRow.setBackgroundColor(Color.LTGRAY);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.

                    mListener.onListFragmentInteraction(holder.mItem, fragment);

                    /*
                    Context context = v.getContext();
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);//need context
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
                    View v = inflater.inflate(R.layout.textbox, null);
                    //above line makes a new view with a given xml (textbox) in this case.
                    //next line gets the input text box from that view. (notice the v. )
                    final EditText dialogBoxText = (EditText)v.findViewById(R.id.menuBox1);
                    final TextView selected = (TextView)ll.getChildAt(item.getItemId());
                    builder.setView(v);
                    builder.setTitle("Add Description");
                    builder.setCancelable(true);
                    builder.setPositiveButton("ok",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            //Do something on okay push!
                            //Take the text from the dialog box and replace the text view with it.
                            selected.setText(dialogBoxText.getText().toString());
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show(); */
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public IScheduleItem getItem(int position) {
        return mValues.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTimeView;
        public final TextView mNameView;
        public IScheduleItem mItem;
        public final LinearLayout mRow;
        public final Button mButtonView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mView
            mRow = (LinearLayout)view.findViewById(R.id.rowLayout);
            mRow.setOnClickListener(new customListener());
            mTimeView = (TextView) view.findViewById(R.id.time);
            mTimeView.setOnClickListener(new customListener());
            mNameView = (TextView) view.findViewById(R.id.name);
            mNameView.setOnClickListener(new customListener());
            mButtonView = (Button) view.findViewById(R.id.button);
            mButtonView.setOnClickListener(new AddListener());
        }

        public class customListener implements View.OnClickListener{
            @Override
            public void onClick(View v){
                //pop up alert dialog box (or whatever..)
                IScheduleItem isi = mValues.get(v.getId());
                Log.d("JOSH","TEST ON CLICK " + v.getId() + " " + isi.getName());
            }
        }

        public class AddListener implements View.OnClickListener{
            @Override
            public void onClick(View v){
                Log.d("Michael", "Add Button Clicked");
            }
        }
        @Override
        public String toString() {
            return " '" + mNameView.getText() + "'";
        }
    }



}
