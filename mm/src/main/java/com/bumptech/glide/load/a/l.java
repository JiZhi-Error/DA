package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {
    private final ContentResolver aFp;
    private T data;
    private final Uri uri;

    /* access modifiers changed from: protected */
    public abstract void R(T t);

    /* access modifiers changed from: protected */
    public abstract T a(Uri uri2, ContentResolver contentResolver);

    public l(ContentResolver contentResolver, Uri uri2) {
        this.aFp = contentResolver;
        this.uri = uri2;
    }

    @Override // com.bumptech.glide.load.a.d
    public final void a(g gVar, d.a<? super T> aVar) {
        try {
            this.data = a(this.uri, this.aFp);
            aVar.S(this.data);
        } catch (FileNotFoundException e2) {
            Log.isLoggable("LocalUriFetcher", 3);
            aVar.e(e2);
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public final void cleanup() {
        if (this.data != null) {
            try {
                R(this.data);
            } catch (IOException e2) {
            }
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.a.d
    public final a ot() {
        return a.LOCAL;
    }
}
