package com.bumptech.glide.load.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d implements j<Uri, Drawable> {
    private final Context context;

    /* Return type fixed from 'com.bumptech.glide.load.b.v' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ v<Drawable> a(Uri uri, int i2, int i3, i iVar) {
        AppMethodBeat.i(77463);
        v<Drawable> m = m(uri);
        AppMethodBeat.o(77463);
        return m;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.bumptech.glide.load.i] */
    @Override // com.bumptech.glide.load.j
    public final /* synthetic */ boolean a(Uri uri, i iVar) {
        AppMethodBeat.i(77464);
        boolean equals = uri.getScheme().equals("android.resource");
        AppMethodBeat.o(77464);
        return equals;
    }

    public d(Context context2) {
        AppMethodBeat.i(77459);
        this.context = context2.getApplicationContext();
        AppMethodBeat.o(77459);
    }

    public final v<Drawable> m(Uri uri) {
        AppMethodBeat.i(77460);
        Context a2 = a(uri, uri.getAuthority());
        v<Drawable> u = c.u(a.b(this.context, a2, b(a2, uri)));
        AppMethodBeat.o(77460);
        return u;
    }

    private Context a(Uri uri, String str) {
        AppMethodBeat.i(204481);
        if (str.equals(this.context.getPackageName())) {
            Context context2 = this.context;
            AppMethodBeat.o(204481);
            return context2;
        }
        try {
            Context createPackageContext = this.context.createPackageContext(str, 0);
            AppMethodBeat.o(204481);
            return createPackageContext;
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.context.getPackageName())) {
                Context context3 = this.context;
                AppMethodBeat.o(204481);
                return context3;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: ".concat(String.valueOf(uri)), e2);
            AppMethodBeat.o(204481);
            throw illegalArgumentException;
        }
    }

    private static int b(Context context2, Uri uri) {
        AppMethodBeat.i(204482);
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            int c2 = c(context2, uri);
            AppMethodBeat.o(204482);
            return c2;
        } else if (pathSegments.size() == 1) {
            int n = n(uri);
            AppMethodBeat.o(204482);
            return n;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(204482);
            throw illegalArgumentException;
        }
    }

    private static int c(Context context2, Uri uri) {
        int i2;
        AppMethodBeat.i(204483);
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context2.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            i2 = Resources.getSystem().getIdentifier(str2, str, "android");
        } else {
            i2 = identifier;
        }
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to find resource id for: ".concat(String.valueOf(uri)));
            AppMethodBeat.o(204483);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(204483);
        return i2;
    }

    private static int n(Uri uri) {
        AppMethodBeat.i(204484);
        try {
            int parseInt = Integer.parseInt(uri.getPathSegments().get(0));
            AppMethodBeat.o(204484);
            return parseInt;
        } catch (NumberFormatException e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(uri)), e2);
            AppMethodBeat.o(204484);
            throw illegalArgumentException;
        }
    }
}
