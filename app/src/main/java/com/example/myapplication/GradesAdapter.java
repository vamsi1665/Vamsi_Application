package com.example.myapplication;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GradesAdapter extends  RecyclerView.Adapter<GradesAdapter.ViewHolder> {

    private List<MyItem> myItems;
    private ItemListener myListener;

    public GradesAdapter(List<MyItem> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_gradespinner, parent, false)); // TODO
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(myItems.get(position));
    }

    public interface ItemListener {
        void onItemClick(MyItem item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public MyItem item;
        public EditText et;
        public Spinner sp;

        public ViewHolder(View itemView) {
            super(itemView);
            sp = itemView.findViewById(R.id.grade);
            et = itemView.findViewById(R.id.credits);
            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    item.setSubgrade(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    item.setSubgrade(0);
                }
            });
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (!TextUtils.isEmpty(charSequence.toString()))
                        item.setCredits(Integer.parseInt(charSequence.toString()));
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            itemView.setOnClickListener(this);
            // TODO instantiate/assign view members
        }

        public void setData(MyItem item) {
            this.item = item;
            et.setText(String.valueOf(item.getCredits()));
            sp.setSelection(item.getSubgrade());
            // TODO set data to view
        }

        @Override
        public void onClick(View v) {
            if (myListener != null) {
                myListener.onItemClick(item);
            }
        }
    }


}
