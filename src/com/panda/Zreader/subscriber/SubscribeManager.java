package com.panda.Zreader.subscriber;

import android.content.Context;
import com.panda.Zreader.constant.TestConstants;
import com.panda.Zreader.database.DBManager;
import com.panda.Zreader.loader.HomePageParser;
import com.panda.Zreader.storage.Website;

import java.util.List;

/**
 * Created by yzhou7 on 2015/7/27.
 */
public class SubscribeManager {

    private final Context ctx;
    private final DBManager mgr;

    public SubscribeManager(Context ctx) {
        this.ctx = ctx;
        this.mgr = new DBManager(ctx);
    }

    /**
     * Parse home page and add site to DB asynchronously.
     * @param url
     */
    public void subscribe(String url) {
        url = TestConstants.TestRssUrl;
        HomePageParser parser = new HomePageParser(url, ctx);
        parser.parse();
    }

    // TODO remove website and all posts.
    public void unSubscribe() {

    }

    /**
     * Load current sites subscribed.
     *
     * @return list of website object
     */
    public List<Website> getAll() {
        return mgr.getAllWebsites();
    }

    public void destory() {
        mgr.closeDB();
    }
}
