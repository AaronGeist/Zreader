package com.panda.Zreader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import com.panda.Zreader.R;
import com.panda.Zreader.constant.DBContants;
import com.panda.Zreader.database.DBManager;
import com.panda.Zreader.storage.Post;

/**
 * Created by yzhou7 on 2015/8/7.
 */
public class PostActivity extends Activity {

    DBManager dbManager = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        Intent intent = this.getIntent();
        long postId = intent.getLongExtra(DBContants.COLUMN_ID, 0);
        dbManager = new DBManager(this);
        loadPost(postId);
    }

    public void loadPost(long postId) {
        Log.d("", "Loading post id=" + postId);
        Post post = dbManager.getSinglePost(postId);

        final TextView title = (TextView) findViewById(R.id.singlePostTitle);
        title.setText(post.getTitle());
        final WebView content = (WebView) findViewById(R.id.singlePostContent);
        content.loadDataWithBaseURL(post.getUrl(), post.getContent(), "text/html", "utf-8", null);
    }
}
