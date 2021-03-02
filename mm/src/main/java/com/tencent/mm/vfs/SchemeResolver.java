package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.vfs.FileSystem;

public interface SchemeResolver extends Parcelable {

    public interface a {
        Pair<FileSystem.b, String> a(k kVar, Uri uri);

        SchemeResolver hem();
    }

    a hel();
}
