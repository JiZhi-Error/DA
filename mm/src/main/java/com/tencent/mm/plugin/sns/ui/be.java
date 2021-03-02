package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class be {
    static double EGA = -1.0d;
    static double EGB = -1.0d;
    static double EGC = -1.0d;
    static double EGD = -1.0d;
    static double EGE = -1.0d;
    private static boolean EGG;
    public static int EGH = -1;
    public static int[] EGv = {0, 0, 1, 3, 6, 9};
    public static int[] EGw = {R.id.k0};
    public static int[] EGx = {R.id.k0, R.id.k1, R.id.k2};
    public static int[] EGy = {R.id.k0, R.id.k1, R.id.k2, R.id.k3, R.id.k4, R.id.k5};
    public static int[] EGz = {R.id.k0, R.id.k1, R.id.k2, R.id.k3, R.id.k4, R.id.k5, R.id.k6, R.id.k7, R.id.k8};
    private LinkedList<LinearLayout> EGF = new LinkedList<>();
    private Context context;

    public be(Context context2) {
        AppMethodBeat.i(98907);
        this.context = context2;
        if (this.context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Point point = new Point();
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
            aj.k(point);
        }
        EGG = 1 == ((b) g.af(b.class)).a(b.a.clicfg_sns_group_download, 0);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            EGG = true;
        }
        AppMethodBeat.o(98907);
    }

    public final void a(PhotosContent photosContent, TimeLineObject timeLineObject, String str, int i2, int i3, int i4, boolean z, bp bpVar, boolean z2) {
        AppMethodBeat.i(98908);
        int[] iArr = EGz;
        if (i3 == 2 || i3 == 10) {
            iArr = EGw;
        } else if (i3 == 3) {
            iArr = EGx;
        } else if (i3 == 4) {
            iArr = EGy;
        } else if (i3 == 5) {
            iArr = EGz;
        }
        LinkedList<cnb> linkedList = timeLineObject.ContentObj.LoV;
        if (EGA < 0.0d) {
            EGA = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0f);
            EGB = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0f);
            EGC = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0f);
            EGD = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0f);
            EGE = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0f);
        }
        int size = linkedList.size();
        if (size == 0) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                aj.faL().ff(photosContent.ZD(i5));
                photosContent.ZD(i5).setPosition(i4);
            }
            photosContent.setVisibility(8);
            AppMethodBeat.o(98908);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (int i6 = 1; i6 < iArr.length; i6++) {
                TagImageView ZD = photosContent.ZD(i6);
                ZD.setVisibility(8);
                aj.faL().ff(ZD);
                photosContent.ZD(i6).setPosition(i4);
            }
            photosContent.ZD(0).setVisibility(0);
            a(linkedList.get(0), photosContent.ZD(0), str, i2, i4, z, bpVar, i3, z2, null);
            AppMethodBeat.o(98908);
            return;
        }
        AppMethodBeat.o(98908);
    }

    public final void a(PhotosContent photosContent, TimeLineObject timeLineObject, String str, int i2, int i3, int i4, boolean z, boolean z2, bp bpVar, List<cnd> list, String str2, SnsInfo snsInfo) {
        AppMethodBeat.i(203616);
        int[] iArr = EGz;
        if (i3 == 2 || i3 == 10 || i3 == 13) {
            iArr = EGw;
        } else if (i3 == 3) {
            iArr = EGx;
        } else if (i3 == 4) {
            iArr = EGy;
        } else if (i3 == 5) {
            iArr = EGz;
        }
        LinkedList<cnb> linkedList = timeLineObject.ContentObj.LoV;
        if (EGA < 0.0d) {
            EGA = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0f);
            EGB = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0f);
            EGC = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0f);
            EGD = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0f);
            EGE = (double) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0f);
        }
        int size = linkedList.size();
        if (size == 0) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                aj.faL().ff(photosContent.ZD(i5));
                photosContent.ZD(i5).setPosition(i4);
            }
            photosContent.setVisibility(8);
            AppMethodBeat.o(203616);
            return;
        }
        photosContent.setImageViewWidth(aj.fbb());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (int i6 = 1; i6 < iArr.length; i6++) {
                TagImageView ZD = photosContent.ZD(i6);
                ZD.setVisibility(8);
                aj.faL().ff(ZD);
                photosContent.ZD(i6).setPosition(i4);
            }
            photosContent.ZD(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a(linkedList.get(0), photosContent.ZD(0), str, i2, i4, z2, bpVar, i3, false, snsInfo);
                AppMethodBeat.o(203616);
                return;
            }
            a(linkedList.get(0), photosContent.ZD(0), str, i2, i4, z2, bpVar, i3, false, list.get(0), snsInfo);
            AppMethodBeat.o(203616);
            return;
        }
        c.C1718c cVar = !fiv() ? new c.C1718c(str2, size) : null;
        if (size == 4) {
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            int i7 = 3;
            for (int length = iArr.length - 1; length >= 0; length--) {
                TagImageView ZD2 = photosContent.ZD(length);
                ZD2.setPosition(i4);
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    ZD2.setVisibility(0);
                    arrayList.add(ZD2);
                    bc bcVar = new bc();
                    bcVar.dJX = str;
                    int i8 = i7 - 1;
                    bcVar.index = i7;
                    bcVar.EDW = arrayList;
                    bcVar.EAv = z2;
                    bcVar.position = i4;
                    ZD2.setTag(bcVar);
                    if (z || !fiv()) {
                        cnb cnb = linkedList.get(bcVar.index);
                        aj.faJ().a(cnb.Id, cVar);
                        aj.faJ().aOT(cnb.Id);
                        a(cnb, ZD2, i2, bpVar);
                    }
                    sparseArray.put(bcVar.index, linkedList.get(bcVar.index));
                    sparseArray2.put(bcVar.index, ZD2);
                    i7 = i8;
                } else {
                    ZD2.setVisibility(8);
                    aj.faL().ff(ZD2);
                }
            }
            if (!z && fiv() && sparseArray.size() > 0) {
                a(str2, sparseArray, sparseArray2, i2, bpVar, size);
            }
            AppMethodBeat.o(203616);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray3 = new SparseArray();
        SparseArray sparseArray4 = new SparseArray();
        for (int length2 = iArr.length - 1; length2 >= 0; length2--) {
            TagImageView ZD3 = photosContent.ZD(length2);
            ZD3.setPosition(i4);
            if (length2 < linkedList.size()) {
                ZD3.setVisibility(0);
                arrayList2.add(ZD3);
                bc bcVar2 = new bc();
                bcVar2.dJX = str;
                bcVar2.index = length2;
                bcVar2.EDW = arrayList2;
                bcVar2.EAv = z2;
                bcVar2.position = i4;
                ZD3.setTag(bcVar2);
                if (z || !fiv()) {
                    cnb cnb2 = linkedList.get(bcVar2.index);
                    aj.faJ().a(cnb2.Id, cVar);
                    aj.faJ().aOT(cnb2.Id);
                    a(cnb2, ZD3, i2, bpVar);
                }
                sparseArray3.put(bcVar2.index, linkedList.get(bcVar2.index));
                sparseArray4.put(bcVar2.index, ZD3);
            } else {
                ZD3.setVisibility(8);
                aj.faL().ff(ZD3);
            }
        }
        if (!z && fiv() && sparseArray3.size() > 0) {
            a(str2, sparseArray3, sparseArray4, i2, bpVar, size);
        }
        AppMethodBeat.o(203616);
    }

    public static boolean fiv() {
        AppMethodBeat.i(98910);
        Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", Integer.valueOf(EGH));
        switch (EGH) {
            case 1:
                Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
                CdnLogic.setSnsImagePrivateProtocolAvalible(true);
                CdnLogic.setSnsImageStreamProtocolAvalible(true);
                AppMethodBeat.o(98910);
                return true;
            case 2:
                Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
                AppMethodBeat.o(98910);
                return false;
            default:
                boolean allowBatchImageDownload = CdnLogic.allowBatchImageDownload();
                Log.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", Boolean.valueOf(allowBatchImageDownload), Boolean.valueOf(EGG));
                if (!allowBatchImageDownload || !EGG) {
                    Log.i("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
                    AppMethodBeat.o(98910);
                    return false;
                }
                AppMethodBeat.o(98910);
                return true;
        }
    }

    private static void a(cnb cnb, QFadeImageView qFadeImageView, int i2, bp bpVar) {
        AppMethodBeat.i(98911);
        aj.faL().b(cnb, qFadeImageView, i2, bpVar);
        AppMethodBeat.o(98911);
    }

    private static void a(String str, SparseArray<cnb> sparseArray, SparseArray<View> sparseArray2, int i2, bp bpVar, int i3) {
        AppMethodBeat.i(98912);
        aj.faL().a(str, sparseArray, sparseArray2, i2, bpVar, i3);
        AppMethodBeat.o(98912);
    }

    private void a(cnb cnb, QFadeImageView qFadeImageView, String str, int i2, int i3, boolean z, bp bpVar, int i4, boolean z2, cnd cnd, SnsInfo snsInfo) {
        double d2;
        double d3;
        double d4;
        AppMethodBeat.i(203617);
        if (qFadeImageView == null) {
            Log.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            AppMethodBeat.o(203617);
            return;
        }
        bc bcVar = new bc();
        bcVar.dJX = str;
        bcVar.index = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        bcVar.EDW = arrayList;
        bcVar.EAv = z;
        bcVar.position = i3;
        qFadeImageView.setTag(bcVar);
        double d5 = 0.0d;
        double d6 = 0.0d;
        if (i4 != 10 || !z2) {
            aj.faL().a(cnb, qFadeImageView, i2, bpVar);
        } else {
            aj.faL().c(cnb, qFadeImageView, i2, bpVar);
        }
        if (cnb.MsB != null) {
            d5 = (double) cnb.MsB.Mto;
            d6 = (double) cnb.MsB.Mtp;
        }
        if (i4 != 2 || snsInfo == null || !snsInfo.isFinderAd()) {
            if (d5 <= 0.0d || d6 <= 0.0d) {
                d2 = EGA;
                d3 = EGA;
            } else {
                double min = Math.min(EGB / d5, EGB / d6);
                double d7 = d5 * min;
                d3 = d6 * min;
                if (d7 < EGC) {
                    double d8 = (1.0d * EGC) / d7;
                    d7 *= d8;
                    d3 *= d8;
                }
                if (d3 < EGC) {
                    double d9 = (1.0d * EGC) / d3;
                    d7 *= d9;
                    d3 *= d9;
                }
                if (d7 > EGB) {
                    d7 = EGB;
                }
                if (d3 > EGB) {
                    d3 = EGB;
                }
                d2 = d7;
            }
            if (d2 < 1.0d) {
                d2 = 1.0d;
            }
            if (d3 < 1.0d) {
                d3 = 1.0d;
            }
            if (cnd == null || cnd.Mto <= 0.0f || cnd.Mtp <= 0.0f) {
                d4 = d3;
            } else {
                d2 = (double) cnd.Mto;
                d4 = (double) cnd.Mtp;
            }
        } else {
            Pair<Integer, Integer> a2 = n.a((int) d5, (int) d6, this.context, false);
            d2 = (double) ((Integer) a2.first).intValue();
            d4 = (double) ((Integer) a2.second).intValue();
        }
        if (qFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) == d2 && ((double) layoutParams.height) == d4) {
                AppMethodBeat.o(203617);
                return;
            }
            qFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int) d2, (int) d4));
        }
        AppMethodBeat.o(203617);
    }

    private void a(cnb cnb, QFadeImageView qFadeImageView, String str, int i2, int i3, boolean z, bp bpVar, int i4, boolean z2, SnsInfo snsInfo) {
        AppMethodBeat.i(203618);
        a(cnb, qFadeImageView, str, i2, i3, z, bpVar, i4, z2, new cnd(), snsInfo);
        AppMethodBeat.o(203618);
    }
}
