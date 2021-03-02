package com.tencent.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class k extends q {
    public k(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final String read() {
        String string;
        AppMethodBeat.i(87629);
        synchronized (this) {
            try {
                s.Uf();
                string = PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
            } finally {
                AppMethodBeat.o(87629);
            }
        }
        return string;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final void write(String str) {
        AppMethodBeat.i(87630);
        synchronized (this) {
            try {
                s.Uf();
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                edit.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
                edit.commit();
            } finally {
                AppMethodBeat.o(87630);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final boolean TW() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final a TX() {
        a aVar;
        AppMethodBeat.i(87631);
        synchronized (this) {
            try {
                aVar = new a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
                new StringBuilder("read CheckEntity from sharedPreferences:").append(aVar.toString());
                s.Uf();
            } finally {
                AppMethodBeat.o(87631);
            }
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final void a(a aVar) {
        AppMethodBeat.i(87632);
        synchronized (this) {
            try {
                new StringBuilder("write CheckEntity to sharedPreferences:").append(aVar.toString());
                s.Uf();
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                edit.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
                edit.commit();
            } finally {
                AppMethodBeat.o(87632);
            }
        }
    }
}
