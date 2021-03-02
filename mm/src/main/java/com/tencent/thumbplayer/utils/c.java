package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;

public final class c {
    private a Sff = null;
    private a Sfg = null;
    private ArrayList<String> Sfh = new ArrayList<>();
    private String Sfi = null;

    public c(Context context, String str) {
        AppMethodBeat.i(189626);
        this.Sff = a.cW(context, str);
        this.Sfi = str + "_key";
        this.Sfg = a.cW(context, this.Sfi);
        AppMethodBeat.o(189626);
    }

    public final synchronized void a(String str, Serializable serializable) {
        AppMethodBeat.i(189627);
        if (serializable == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(189627);
        } else {
            this.Sff.remove(str);
            this.Sff.put(str, serializable);
            this.Sfh.remove(str);
            this.Sfh.add(str);
            this.Sfg.remove(this.Sfi);
            this.Sfg.put(this.Sfi, this.Sfh);
            AppMethodBeat.o(189627);
        }
    }

    public final synchronized Object hoo() {
        ArrayList arrayList;
        Object asObject;
        ArrayList arrayList2 = null;
        synchronized (this) {
            AppMethodBeat.i(189628);
            ArrayList arrayList3 = (ArrayList) this.Sfg.getAsObject(this.Sfi);
            if (arrayList3 == null || arrayList3.size() <= 0) {
                AppMethodBeat.o(189628);
            } else {
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    String str = (String) arrayList3.get(i2);
                    if (TextUtils.isEmpty(str) || (asObject = this.Sff.getAsObject(str)) == null) {
                        arrayList = arrayList2;
                    } else {
                        if (arrayList2 == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = arrayList2;
                        }
                        arrayList.add(asObject);
                    }
                    i2++;
                    arrayList2 = arrayList;
                }
                this.Sff.clear();
                this.Sfg.clear();
                this.Sfh.clear();
                AppMethodBeat.o(189628);
            }
        }
        return arrayList2;
    }

    public final synchronized void bqG(String str) {
        AppMethodBeat.i(189629);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(189629);
        } else {
            this.Sff.remove(str);
            this.Sfh.remove(str);
            this.Sfg.remove(this.Sfi);
            this.Sfg.put(this.Sfi, this.Sfh);
            AppMethodBeat.o(189629);
        }
    }
}
