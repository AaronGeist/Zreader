package com.panda.Zreader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.panda.Zreader.R;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // set button trigger
        addBtnListener();
    }

    protected void addBtnListener() {
        final Button triggerButton = (Button) findViewById(R.id.triggerButton);
        triggerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String baseURL = "http://www.importnew.com/all-posts";
//                String html = "";
//                try {
//                    URL url = new URL(baseURL);
//                    AsyncWebPageLoader task = new AsyncWebPageLoader();
//                    html = task.execute(url).get().html();
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//
//                final WebView webView = (WebView) findViewById(R.id.webContainer);
//                webView.loadDataWithBaseURL(baseURL, html, "text/html", "utf-8", null);
            }
        });


        Button addFeedBtn = (Button) findViewById(R.id.subscribePageBtn);
        addFeedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), SubscribeActivity.class);
                startActivity(intent);
            }
        });

    }



}
