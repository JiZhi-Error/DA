package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.k;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k {
    private static Object yJY = new Object();
    protected float aTD = 0.0f;
    protected float aTE = 0.0f;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.ui.k.AnonymousClass4 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(55966);
            if (!z) {
                AppMethodBeat.o(55966);
                return false;
            }
            k kVar = k.this;
            double d4 = (double) f3;
            double d5 = (double) f2;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[refreshMyLocation] ");
            stringBuffer.append(String.format("latitude = %f, longtitude = %f", Double.valueOf(d4), Double.valueOf(d5)));
            if (kVar.yGJ == null) {
                kVar.yGJ = new eox();
                kVar.yGJ.NmV = new ddj();
                kVar.yGJ.Username = z.aTY();
                kVar.yGJ.NmV.KUu = d4;
                kVar.yGJ.NmV.KUt = d5;
                if (kVar.yHH && kVar.yKb) {
                    kVar.edz();
                }
            }
            kVar.yGJ.NmV.KUu = d4;
            kVar.yGJ.NmV.KUt = d5;
            Object viewByItag = kVar.yHG.getViewByItag(kVar.yGJ.Username);
            if (viewByItag != null) {
                stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
            } else {
                TrackPoint trackPoint = new TrackPoint(kVar.mContext, (ViewManager) kVar.yHG.getViewManager(), (byte) 0);
                kVar.yHG.addView(trackPoint, 0.0d, 0.0d, kVar.yGJ.Username);
                trackPoint.o(d4, d5);
                if (kVar.yKg) {
                    trackPoint.setOnAvatarOnClickListener(null);
                    trackPoint.setOnLocationOnClickListener(null);
                    trackPoint.eee();
                } else {
                    trackPoint.setOnAvatarOnClickListener(kVar.yKo);
                    trackPoint.setOnLocationOnClickListener(kVar.yKn);
                }
                trackPoint.setAvatar(kVar.yGJ.Username);
                stringBuffer.append("[view is null new one: " + trackPoint.hashCode() + " ] ");
                kVar.yKa = new TrackPointAnimAvatar(kVar.mContext);
                viewByItag = trackPoint;
            }
            Log.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
            if (viewByItag instanceof TrackPoint) {
                kVar.yJZ = (TrackPoint) viewByItag;
                Log.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
                kVar.yJZ.n(d4, d5);
            }
            if (kVar.yKi) {
                kVar.yHG.getIController().setCenter(kVar.yGJ.NmV.KUu, kVar.yGJ.NmV.KUt);
            }
            AppMethodBeat.o(55966);
            return true;
        }
    };
    Context mContext;
    private boolean mbo = false;
    public eox yGJ;
    private k.a yGU = new k.a() {
        /* class com.tencent.mm.plugin.location.ui.k.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.location.model.k.a
        public final void w(double d2) {
            AppMethodBeat.i(55967);
            if (k.this.yJZ != null) {
                Log.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", Double.valueOf(d2));
                k.this.yJZ.x(d2);
            }
            AppMethodBeat.o(55967);
        }
    };
    public d yHG;
    boolean yHH = false;
    public List<eox> yJX;
    public TrackPoint yJZ;
    TrackPointAnimAvatar yKa;
    boolean yKb = false;
    public boolean yKc = false;
    public boolean yKd = true;
    public boolean yKe = false;
    public boolean yKf = false;
    public boolean yKg = false;
    public ejg yKh;
    public boolean yKi = true;
    public boolean yKj = true;
    private boolean yKk = false;
    private long yKl = 0;
    private View.OnTouchListener yKm = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.location.ui.k.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(55963);
            switch (motionEvent.getAction()) {
                case 0:
                    k.this.aTD = motionEvent.getX();
                    k.this.aTE = motionEvent.getY();
                    k.this.yKl = System.currentTimeMillis();
                    k.this.mbo = false;
                    break;
                case 1:
                    if (!k.this.mbo && System.currentTimeMillis() - k.this.yKl < 200) {
                        k.c(k.this);
                        break;
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - k.this.aTD) > 10.0f || Math.abs(motionEvent.getY() - k.this.aTE) > 10.0f) {
                        k.this.mbo = true;
                        break;
                    }
            }
            AppMethodBeat.o(55963);
            return false;
        }
    };
    View.OnClickListener yKn = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.location.ui.k.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(55964);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(55964);
        }
    };
    View.OnClickListener yKo = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.location.ui.k.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(55965);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            k.a(k.this, iArr[0], iArr[1]);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(55965);
        }
    };
    public a yKp = null;

    public interface a {
    }

    static {
        AppMethodBeat.i(55980);
        AppMethodBeat.o(55980);
    }

    public k(Context context, d dVar, boolean z) {
        AppMethodBeat.i(55968);
        this.mContext = context;
        this.yHH = z;
        this.yHG = dVar;
        this.yJX = new ArrayList();
        dVar.setMapViewOnTouchListener(this.yKm);
        AppMethodBeat.o(55968);
    }

    public final void qI(boolean z) {
        boolean z2;
        AppMethodBeat.i(55969);
        if (z) {
            if (this.yJZ != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                h.INSTANCE.a(10997, "20", 0, 0, 0);
            }
            AppMethodBeat.o(55969);
        }
        this.yKf = z;
        AppMethodBeat.o(55969);
    }

    public final void destroy() {
        AppMethodBeat.i(55970);
        synchronized (yJY) {
            try {
                if (this.yJX != null) {
                    this.yJX.clear();
                }
                this.yHG.clean();
            } finally {
                AppMethodBeat.o(55970);
            }
        }
    }

    public final void qJ(boolean z) {
        AppMethodBeat.i(55971);
        if (z && !this.yKe && this.yHG != null) {
            for (Object obj : this.yHG.getChilds()) {
                if (obj instanceof TrackPoint) {
                    ((TrackPoint) obj).eef();
                }
            }
        }
        this.yKe = z;
        AppMethodBeat.o(55971);
    }

    public final void fm(List<eox> list) {
        TrackPoint trackPoint;
        AppMethodBeat.i(55972);
        this.yKb = true;
        int size = this.yJX.size() + 1;
        synchronized (yJY) {
            try {
                this.yJX.clear();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.yJX.add(list.get(i2));
                }
            } finally {
                AppMethodBeat.o(55972);
            }
        }
        int size2 = this.yJX.size() + 1;
        synchronized (yJY) {
            try {
                Set<String> tags = this.yHG.getTags();
                HashSet hashSet = new HashSet();
                for (int i3 = 0; i3 < this.yJX.size(); i3++) {
                    hashSet.add(this.yJX.get(i3).Username);
                }
                LinkedList<String> linkedList = new LinkedList();
                for (String str : tags) {
                    if (!hashSet.contains(str) && !str.endsWith("myAnim")) {
                        if (this.yJZ == null || !this.yJZ.equals(this.yHG.getViewByItag(str))) {
                            linkedList.add(str);
                        }
                    }
                }
                for (String str2 : linkedList) {
                    Object viewByItag = this.yHG.getViewByItag(str2);
                    if (viewByItag instanceof TrackPoint) {
                        TrackPoint trackPoint2 = (TrackPoint) viewByItag;
                        if (trackPoint2.mViewManager != null) {
                            trackPoint2.mViewManager.removeView(trackPoint2.yOd);
                            trackPoint2.mViewManager.removeView(trackPoint2.yOe);
                        }
                    }
                    this.yHG.removeViewByTag(str2);
                }
                for (int i4 = 0; i4 < this.yJX.size(); i4++) {
                    eox eox = this.yJX.get(i4);
                    Object viewByItag2 = this.yHG.getViewByItag(eox.Username);
                    Log.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", Integer.valueOf(i4), eox.Username, Double.valueOf(eox.NmV.KUu), Double.valueOf(eox.NmV.KUt), Double.valueOf(eox.NmV.MIv));
                    if (viewByItag2 == null) {
                        TrackPoint trackPoint3 = new TrackPoint(this.mContext, (ViewManager) this.yHG.getViewManager());
                        this.yHG.addView(trackPoint3, eox.NmV.KUu, eox.NmV.KUt, eox.Username);
                        trackPoint3.o(eox.NmV.KUu, eox.NmV.KUt);
                        trackPoint3.setOnAvatarOnClickListener(this.yKo);
                        trackPoint3.setOnLocationOnClickListener(this.yKn);
                        trackPoint = trackPoint3;
                    } else if (viewByItag2 instanceof TrackPoint) {
                        ((TrackPoint) viewByItag2).n(eox.NmV.KUu, eox.NmV.KUt);
                        trackPoint = viewByItag2;
                    } else {
                        trackPoint = viewByItag2;
                    }
                    if (trackPoint instanceof TrackPoint) {
                        TrackPoint trackPoint4 = (TrackPoint) trackPoint;
                        trackPoint4.setAvatar(eox.Username);
                        trackPoint4.x(eox.NmV.MIv);
                        if (!this.yKe) {
                            trackPoint4.eee();
                        }
                    }
                }
                if (this.yHH && this.yKb) {
                    if (ab.Eq(n.ecR().rgD)) {
                        edz();
                    } else if (this.yJX.size() > 0) {
                        edz();
                    }
                }
                if (size < 10 && size2 >= 10) {
                    for (Object obj : this.yHG.getChilds()) {
                        if (obj instanceof TrackPoint) {
                            ((TrackPoint) obj).eee();
                        }
                    }
                } else if (size >= 10 && size2 < 10) {
                    for (Object obj2 : this.yHG.getChilds()) {
                        if (obj2 instanceof TrackPoint) {
                            ((TrackPoint) obj2).eef();
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(55972);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void edz() {
        AppMethodBeat.i(55973);
        if (this.yKc) {
            AppMethodBeat.o(55973);
        } else if (this.yGJ == null) {
            AppMethodBeat.o(55973);
        } else {
            edA();
            this.yKc = true;
            AppMethodBeat.o(55973);
        }
    }

    private void edA() {
        AppMethodBeat.i(55974);
        double d2 = 0.0d;
        double d3 = 0.0d;
        if (this.yGJ == null) {
            AppMethodBeat.o(55974);
            return;
        }
        LocationInfo locationInfo = n.ecR().yGK;
        if (this.yGJ != null && e.j(locationInfo.yFu, locationInfo.yFv)) {
            d2 = 2.0d * Math.abs(this.yGJ.NmV.KUu - locationInfo.yFu);
            d3 = Math.abs(this.yGJ.NmV.KUt - locationInfo.yFv) * 2.0d;
        }
        double d4 = d3;
        double d5 = d2;
        for (int i2 = 0; i2 < this.yJX.size(); i2++) {
            eox eox = this.yJX.get(i2);
            if (eox != null && e.j(eox.NmV.KUu, eox.NmV.KUt)) {
                double abs = 2.0d * Math.abs(eox.NmV.KUu - this.yGJ.NmV.KUu);
                double abs2 = Math.abs(eox.NmV.KUt - this.yGJ.NmV.KUt) * 2.0d;
                if (abs > d5) {
                    d5 = abs;
                }
                if (abs2 > d4) {
                    d4 = abs2;
                }
                Log.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", eox.Username, Double.valueOf(eox.NmV.KUu), Double.valueOf(eox.NmV.KUt));
            }
        }
        if (Math.abs(d5 - -1000.0d) < 0.5d || Math.abs(d4 - -1000.0d) < 0.5d) {
            AppMethodBeat.o(55974);
            return;
        }
        Log.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d5) + " maxlng " + (1000000.0d * d4) + " poi " + locationInfo.yFu + " " + locationInfo.yFv);
        if (this.yGJ != null) {
            Log.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", Double.valueOf(this.yGJ.NmV.KUu), Double.valueOf(this.yGJ.NmV.KUt));
            this.yHG.zoomToSpan(this.yGJ.NmV.KUu, this.yGJ.NmV.KUt, d5, d4);
            AppMethodBeat.o(55974);
            return;
        }
        if (e.j(locationInfo.yFu, locationInfo.yFv)) {
            this.yHG.zoomToSpan(locationInfo.yFu, locationInfo.yFv, d5, d4);
        }
        AppMethodBeat.o(55974);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(55975);
        if (this.yGJ == null) {
            AppMethodBeat.o(55975);
        } else if (dVar.getZoomLevel() < 15) {
            dVar.getIController().animateTo(this.yGJ.NmV.KUu, this.yGJ.NmV.KUt, 15);
            AppMethodBeat.o(55975);
        } else {
            dVar.getIController().animateTo(this.yGJ.NmV.KUu, this.yGJ.NmV.KUt);
            AppMethodBeat.o(55975);
        }
    }

    public final void onResume() {
        AppMethodBeat.i(55976);
        com.tencent.mm.modelgeo.d.bca().b(this.gmA, true);
        n.ecT().a(this.yGU);
        AppMethodBeat.o(55976);
    }

    public final void onPause() {
        AppMethodBeat.i(55977);
        com.tencent.mm.modelgeo.d.bca().c(this.gmA);
        n.ecT().b(this.yGU);
        AppMethodBeat.o(55977);
    }

    static /* synthetic */ void c(k kVar) {
        boolean z = true;
        AppMethodBeat.i(55978);
        if (kVar.yKf) {
            kVar.qI(false);
        }
        Collection<Object> childs = kVar.yHG.getChilds();
        Iterator<Object> it = childs.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Object next = it.next();
            if (next instanceof TrackPoint) {
                if (((TrackPoint) next).yOd.getVisibility() == 0) {
                    break;
                }
            }
        }
        for (Object obj : childs) {
            if (obj instanceof TrackPoint) {
                if (z) {
                    ((TrackPoint) obj).eee();
                } else {
                    ((TrackPoint) obj).eef();
                }
            }
        }
        AppMethodBeat.o(55978);
    }

    static /* synthetic */ boolean a(k kVar, int i2, int i3) {
        AppMethodBeat.i(55979);
        if (kVar.yJX != null) {
            ArrayList arrayList = new ArrayList();
            float fromDPToPix = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(kVar.mContext, 85.0f);
            for (eox eox : kVar.yJX) {
                Point pointByGeoPoint = kVar.yHG.getPointByGeoPoint(eox.NmV.KUu, eox.NmV.KUt);
                Log.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(eox.NmV.KUu), Double.valueOf(eox.NmV.KUt), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y));
                if (f.E(pointByGeoPoint.x, pointByGeoPoint.y, i2, i3) < ((double) fromDPToPix)) {
                    arrayList.add(eox.Username);
                }
            }
            if (kVar.yGJ != null) {
                Point pointByGeoPoint2 = kVar.yHG.getPointByGeoPoint(kVar.yGJ.NmV.KUu, kVar.yGJ.NmV.KUt);
                Log.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(kVar.yGJ.NmV.KUu), Double.valueOf(kVar.yGJ.NmV.KUt), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y));
                if (f.E(pointByGeoPoint2.x, pointByGeoPoint2.y, i2, i3) < ((double) fromDPToPix)) {
                    arrayList.add(kVar.yGJ.Username);
                }
            }
            Log.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 1) {
                h.INSTANCE.a(10997, "12", 0, 0, 0);
                b.d(kVar.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                AppMethodBeat.o(55979);
                return true;
            }
        }
        AppMethodBeat.o(55979);
        return false;
    }
}
