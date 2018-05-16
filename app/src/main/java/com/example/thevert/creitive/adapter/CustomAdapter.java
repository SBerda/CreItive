package com.example.thevert.creitive.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.thevert.creitive.R;
import com.example.thevert.creitive.model.BlogList;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;


import java.util.List;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<BlogList> dataList;
    private Context context;

    public CustomAdapter(Context context,List<BlogList> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public View mView;

        private TextView txtTitle;
        private ImageView coverImage;
        private BlogList bl;
        public Context context;

        CustomViewHolder(final View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Log.e("CustomAdapter", "Article clicked id = "+bl.getId());

                }
            });


        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.bl = dataList.get(position);
        holder.context=this.context;

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getImage_url())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
