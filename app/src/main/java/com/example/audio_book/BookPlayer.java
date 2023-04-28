package com.example.audio_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BookPlayer extends AppCompatActivity {

    private ArrayList<Book> arrayList;
    private CustomBookAdapter adapter;
    private ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_player);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Book("Shyamchi Aai Part 1","Sane Guruji",R.raw.shyamchi_aai_1));
        arrayList.add(new Book("Shyamchi Aai Part 2","Sane Guruji",R.raw.shyamchi_aai_2));
        arrayList.add(new Book("(Julius Caesar) Act1 - Scene1","William Shakespeare",R.raw.act1_scene1));
        arrayList.add(new Book("(Julius Caesar) Act1 - Scene2","William Shakespeare",R.raw.act1_scene2));
        arrayList.add(new Book("(Julius Caesar) Act1 - Scene3","William Shakespeare",R.raw.act1_scene3));
        arrayList.add(new Book("(Julius Caesar) Act2 - Scene1","William Shakespeare",R.raw.act2_scene1));
        arrayList.add(new Book("(Julius Caesar) Act2 - Scene2","William Shakespeare",R.raw.act2_scene2));
        arrayList.add(new Book("(Julius Caesar) Act2 - Scene3","William Shakespeare",R.raw.act2_scene3));
        arrayList.add(new Book("(Julius Caesar) Act2 - Scene4","William Shakespeare",R.raw.act2_scene4));
        arrayList.add(new Book("(Julius Caesar) Act3 - Scene1","William Shakespeare",R.raw.act3_scene1));
        arrayList.add(new Book("(Julius Caesar) Act3 - Scene2","William Shakespeare",R.raw.act3_scene2));
        arrayList.add(new Book("(Julius Caesar) Act3 - Scene3","William Shakespeare",R.raw.act3_scene3));


        adapter = new CustomBookAdapter(this, R.layout.custom_music_item, arrayList);
        songList.setAdapter(adapter);
    }
}