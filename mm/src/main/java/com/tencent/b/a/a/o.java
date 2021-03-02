package com.tencent.b.a.a;

import android.content.Context;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o extends q {
    public o(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final boolean TW() {
        AppMethodBeat.i(87617);
        boolean checkPermission = s.checkPermission(this.context, "android.permission.WRITE_SETTINGS");
        AppMethodBeat.o(87617);
        return checkPermission;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final String read() {
        String string;
        AppMethodBeat.i(87618);
        synchronized (this) {
            try {
                s.Uf();
                string = Settings.System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
            } finally {
                AppMethodBeat.o(87618);
            }
        }
        return string;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final void write(String str) {
        AppMethodBeat.i(87619);
        synchronized (this) {
            try {
                s.Uf();
                p.br(this.context).N(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            } finally {
                AppMethodBeat.o(87619);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final a TX() {
        a aVar;
        AppMethodBeat.i(87620);
        synchronized (this) {
            try {
                aVar = new a(Settings.System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
                new StringBuilder("read readCheckEntity from Settings.System:").append(aVar.toString());
                s.Uf();
            } finally {
                AppMethodBeat.o(87620);
            }
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.b.a.a.q
    public final void a(a aVar) {
        AppMethodBeat.i(87621);
        synchronized (this) {
            try {
                new StringBuilder("write CheckEntity to Settings.System:").append(aVar.toString());
                s.Uf();
                p.br(this.context).N(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
            } finally {
                AppMethodBeat.o(87621);
            }
        }
    }
}
