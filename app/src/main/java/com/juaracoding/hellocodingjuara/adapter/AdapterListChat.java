package com.juaracoding.hellocodingjuara.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.juaracoding.hellocodingjuara.R;
import com.juaracoding.hellocodingjuara.model.Biodata;
import com.juaracoding.hellocodingjuara.model.ChatModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterListChat extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ChatModel> items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, ChatModel obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterListChat(Context context, List<ChatModel> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama;
        public TextView txtPesan;
        public TextView txtTimestamp;




        public OriginalViewHolder(View v) {
            super(v);

            txtNama = v.findViewById(R.id.txtNama);
            txtPesan = v.findViewById(R.id.txtPesan);
            txtTimestamp = v.findViewById(R.id.txtTimestamp);


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemchat, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            ChatModel chatmodel = items.get(position);
            view.txtNama.setText(chatmodel.getNama() + " : ");
            view.txtPesan.setText(chatmodel.getPesan());
            view.txtTimestamp.setText(chatmodel.getTimestamp());





        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}