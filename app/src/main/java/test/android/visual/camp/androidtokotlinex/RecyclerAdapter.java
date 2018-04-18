package test.android.visual.camp.androidtokotlinex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dabin on 2018. 4. 18..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<String> datas;
    private int itemLayout;
    public RecyclerAdapter(int itemLayout){
        datas = new ArrayList<>();
        this.itemLayout = itemLayout;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        String contents = datas.get(position);
        holder.no_tv.setText(position+". ");
        holder.content_tv.setText(contents);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addContents(String contents) {
        datas.add(contents);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView content_tv;
        public TextView no_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            content_tv = itemView.findViewById(R.id.content_tv);
            no_tv = itemView.findViewById(R.id.no_tv);
        }
    }
}
