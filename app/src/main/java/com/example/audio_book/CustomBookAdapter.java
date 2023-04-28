package com.example.audio_book;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.audio_book.Book;
import com.example.audio_book.R;

import java.util.ArrayList;

public class CustomBookAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Book> arrayList;
    private MediaPlayer mediaPlayer;
    private Boolean flag = true;

    public CustomBookAdapter(Context context, int layout, ArrayList<Book> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName, txtAuthor;
        ImageView ivPlay, ivStop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);
            viewHolder.ivPlay = convertView.findViewById(R.id.ivPlay);
            viewHolder.ivStop = convertView.findViewById(R.id.ivStop);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Book book = arrayList.get(position);
        viewHolder.txtName.setText(book.getName());
        viewHolder.txtAuthor.setText(book.getAuthor());

        //play music
        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    mediaPlayer = MediaPlayer.create(context, book.getSong());
                    flag = false;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    viewHolder.ivPlay.setImageResource(R.drawable.play);
                }
                else{
                    mediaPlayer.start();
                    viewHolder.ivPlay.setImageResource(R.drawable.pause);
                }
            }
        });

        //stop
        viewHolder.ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHolder.ivPlay.setImageResource(R.drawable.play);
            }
        });
        return convertView;
    }
}
