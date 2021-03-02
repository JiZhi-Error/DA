package com.tencent.mm.ui.base;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public final class o {

    public interface a {
        void f(ImageView imageView);
    }

    public interface b {
        void a(ImageView imageView, MenuItem menuItem);
    }

    public interface c {
        void a(TextView textView, MenuItem menuItem);
    }

    public interface d {
        void a(n nVar);
    }

    public interface e {
        void a(m mVar, View view);
    }

    public interface f {
        void onCreateMMMenu(m mVar);
    }

    public interface g {
        void onMMMenuItemSelected(MenuItem menuItem, int i2);
    }

    public interface h {
        void cy(View view);
    }
}
