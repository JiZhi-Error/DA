package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawCanvasArg implements Parcelable {
    public static final Parcelable.Creator<DrawCanvasArg> CREATOR = new Parcelable.Creator<DrawCanvasArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrawCanvasArg[] newArray(int i2) {
            return new DrawCanvasArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrawCanvasArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145384);
            DrawCanvasArg drawCanvasArg = new DrawCanvasArg(parcel);
            AppMethodBeat.o(145384);
            return drawCanvasArg;
        }
    };
    public List<DrawActionWrapper> kZW = new ArrayList();
    public boolean laA;
    public JSONArray laB;
    public volatile b laC;
    private volatile boolean laD = false;
    public volatile boolean laE = false;
    protected volatile int laF;
    protected volatile int laG;
    public boolean lax;
    public String lay;
    public long laz;

    static /* synthetic */ void a(DrawCanvasArg drawCanvasArg, JSONArray jSONArray) {
        AppMethodBeat.i(145391);
        drawCanvasArg.h(jSONArray);
        AppMethodBeat.o(145391);
    }

    static /* synthetic */ void f(DrawCanvasArg drawCanvasArg) {
        AppMethodBeat.i(145392);
        drawCanvasArg.release();
        AppMethodBeat.o(145392);
    }

    public DrawCanvasArg() {
        AppMethodBeat.i(145385);
        AppMethodBeat.o(145385);
    }

    public DrawCanvasArg(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(145386);
        this.lax = parcel.readInt() == 1;
        this.lay = parcel.readString();
        this.kZW = parcel.readArrayList(DrawCanvasArg.class.getClassLoader());
        this.laz = parcel.readLong();
        this.laA = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(145386);
    }

    public final void h(JSONArray jSONArray) {
        boolean bzk;
        int i2;
        AppMethodBeat.i(145387);
        for (int i3 = 0; i3 < jSONArray.length() && !this.laD; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            BaseDrawActionArg WC = c.bzn().WC(optJSONObject.optString(FirebaseAnalytics.b.METHOD));
            DrawActionWrapper acquire = d.bzo().lab.acquire();
            if (acquire == null) {
                acquire = new DrawActionWrapper();
            }
            if (WC != null) {
                acquire.type = 2;
                WC.parse(optJSONObject);
                acquire.kZv = WC;
            } else {
                acquire.type = 1;
                acquire.kZw = optJSONObject;
            }
            this.kZW.add(acquire);
        }
        LinkedList linkedList = new LinkedList();
        ArrayList<DrawActionWrapper> arrayList = new ArrayList();
        this.laG += this.kZW.size();
        int size = this.kZW.size() - 1;
        int i4 = 0;
        while (size >= 0) {
            DrawActionWrapper drawActionWrapper = this.kZW.get(size);
            switch (drawActionWrapper.type) {
                case 1:
                    bzk = false;
                    break;
                case 2:
                    bzk = drawActionWrapper.kZv.bzk();
                    break;
                default:
                    bzk = false;
                    break;
            }
            if (bzk) {
                Log.i("DrawCanvasArg", "found redudant method %s", drawActionWrapper.getMethod());
                arrayList.add(drawActionWrapper);
                i2 = i4 + 1;
            } else {
                if (!"save".equals(drawActionWrapper.getMethod())) {
                    linkedList.addLast(drawActionWrapper);
                } else if (linkedList.size() <= 0 || !((DrawActionWrapper) linkedList.getLast()).getMethod().equals("restore")) {
                    while (true) {
                        if (linkedList.size() > 0) {
                            if (((DrawActionWrapper) linkedList.removeLast()).getMethod().equals("restore")) {
                                i2 = i4;
                            }
                        }
                    }
                } else {
                    arrayList.add(drawActionWrapper);
                    arrayList.add(linkedList.removeLast());
                    i2 = i4;
                }
                i2 = i4;
            }
            size--;
            i4 = i2;
        }
        this.laF += arrayList.size();
        for (DrawActionWrapper drawActionWrapper2 : arrayList) {
            this.kZW.remove(drawActionWrapper2);
            drawActionWrapper2.reset();
        }
        Log.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", Integer.valueOf(this.laF), Integer.valueOf(i4), Integer.valueOf(this.laG));
        AppMethodBeat.o(145387);
    }

    public final void reset() {
        AppMethodBeat.i(145388);
        if (this.laC == null || this.laC.cancel()) {
            release();
            AppMethodBeat.o(145388);
            return;
        }
        Log.i("DrawCanvasArg", "wait for async over");
        this.laD = true;
        AppMethodBeat.o(145388);
    }

    private synchronized void release() {
        AppMethodBeat.i(145389);
        Log.i("DrawCanvasArg", "release %s", toString());
        this.laG = 0;
        this.laF = 0;
        this.laC = null;
        this.lax = false;
        this.laB = null;
        this.lay = null;
        this.laz = 0;
        this.laA = false;
        this.laD = false;
        this.laE = false;
        Iterator<DrawActionWrapper> it = this.kZW.iterator();
        while (it.hasNext()) {
            DrawActionWrapper next = it.next();
            if (next != null) {
                next.reset();
            }
            it.remove();
        }
        d.bzo().laa.release(this);
        AppMethodBeat.o(145389);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(145390);
        parcel.writeInt(this.lax ? 1 : 0);
        parcel.writeString(this.lay);
        parcel.writeList(this.kZW);
        parcel.writeLong(this.laz);
        if (!this.laA) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.o(145390);
    }

    static {
        AppMethodBeat.i(145393);
        AppMethodBeat.o(145393);
    }
}
