package com.example.anddone;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;
import android.widget.Adapter;
import android.widget.AdapterView;

/**
 * A fragment representing a list of Items.
 *
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TodoTabFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private TodoContent todoContent;
    private TodoTabRecyclerViewAdapter adapter;
    private View view;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TodoTabFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TodoTabFragment newInstance(int columnCount) {
        TodoTabFragment fragment = new TodoTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_todo_tab_list, container, false);

        todoContent = new TodoContent(this);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new TodoTabRecyclerViewAdapter(todoContent.scheduleItems, mListener, this, this.getActivity());
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onListItemClick(View v) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        if (info == null) Log.d("onCreateContextMenu", "menuInfo is null");
        //IScheduleItem item = adapter.getItem(info.position);
        //info.id = 1;
        //info = new AdapterView.AdapterContextMenuInfo(v, 1, 1);
        //Log.d("onCreateContextMenu", String.valueOf(info.id));

        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);

    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //IScheduleItem isi = adapter.getItem(info.position);
        switch (item.getItemId()) {
            case R.id.complete:
                Log.d("ContextMenu-item", item.toString());
                Log.d("ContextMenu-getItemId", String.valueOf(item.getItemId()));
                if (info == null) Log.d("ContextMenu", "MenuInfo is null");
                View selectedView = view.findViewById(item.getItemId());
                //Log.d("onContexItemSelected",selectedView.toString());
                //Object item = getListAdapter().getItem(info.position);

                return true;
            case R.id.start:
                return true;
            case R.id.details:
                return true;
            case R.id.edit:
                return true;
            case R.id.delete:
                return true;
            case R.id.cancel:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(IScheduleItem scheduleItem, Fragment currentFragment);
    }
}
