package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import java.io.IOException;

public abstract class b<T> implements d<T> {
    private final AssetManager aFb;
    private final String assetPath;
    private T data;

    /* access modifiers changed from: protected */
    public abstract void R(T t);

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str);

    public b(AssetManager assetManager, String str) {
        this.aFb = assetManager;
        this.assetPath = str;
    }

    @Override // com.bumptech.glide.load.a.d
    public final void a(g gVar, d.a<? super T> aVar) {
        try {
            this.data = a(this.aFb, this.assetPath);
            aVar.S(this.data);
        } catch (IOException e2) {
            Log.isLoggable("AssetPathFetcher", 3);
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
