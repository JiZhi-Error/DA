package com.tencent.mm.bt;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.b.a;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.z.e;
import com.tencent.mm.z.f;
import com.tencent.tavkit.component.TAVExporter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    com.tencent.mm.view.a Kyf;
    HashMap<h, com.tencent.mm.e.b> Kyg;
    LinkedList<com.tencent.mm.e.b> Kyh;
    private j Kyi;
    Bitmap Kyj;
    private boolean Kyk = true;
    private boolean Kyl = true;
    float Kym = -1.0f;
    public c Kyn;
    h Kyo = h.DEFAULT;
    h Kyp = h.DEFAULT;
    private boolean Kyq = false;
    com.tencent.mm.e.b Kyr = null;
    ab.a diP;
    int outputHeight = -1;
    int outputWidth = -1;

    public interface c {
        boolean b(f fVar);

        void l(Boolean bool);
    }

    @Override // com.tencent.mm.bt.b
    public final void setOutputSize(int i2, int i3) {
        AppMethodBeat.i(204755);
        Log.i("MicroMsg.DrawingPresenter", "setOutputSize width:%d height:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.outputWidth = i2;
        this.outputHeight = i3;
        AppMethodBeat.o(204755);
    }

    @Override // com.tencent.mm.bt.b
    public final void a(com.tencent.mm.view.a aVar) {
        this.Kyf = aVar;
    }

    @Override // com.tencent.mm.bt.b
    public final void a(ab.a aVar) {
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(9297);
        this.diP = aVar;
        this.Kyg = new HashMap<>();
        this.Kyh = new LinkedList<>();
        String str = aVar.path;
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            Log.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", str);
            z = false;
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                Log.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str);
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            if (aVar.diU) {
                this.Kyj = BitmapUtil.decodeFile(aVar.path, null);
                if (this.Kyj != null) {
                    this.Kyj = this.Kyj.copy(Bitmap.Config.ARGB_8888, true);
                }
            } else {
                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(Util.nullAs(aVar.path, ""));
                if (imageOptions != null) {
                    i3 = imageOptions.outWidth;
                    i2 = imageOptions.outHeight;
                    double sqrt = Math.sqrt(1638400.0d / ((double) (i3 * i2)));
                    if (sqrt <= 1.0d) {
                        i3 = (int) (((double) i3) * sqrt);
                        i2 = (int) (sqrt * ((double) i2));
                        if (i3 < 1280 && i2 < 1280) {
                            i2 = 1280;
                            i3 = 1280;
                        }
                    }
                } else {
                    i2 = 1280;
                    i3 = 1280;
                }
                this.Kyj = BitmapUtil.createThumbBitmap(Util.nullAs(aVar.path, ""), i2, i3, true, false);
            }
        } else if (aVar.diR == ab.c.SCREEN) {
            this.Kyj = BitmapUtil.createColorBitmap(aVar.backgroundColor, aVar.diV.width(), aVar.diV.height());
        } else if (this.Kyj == null) {
            this.Kyj = BitmapUtil.createColorBitmap(0, TAVExporter.VIDEO_EXPORT_HEIGHT, TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        gto();
        AppMethodBeat.o(9297);
    }

    @Override // com.tencent.mm.bt.b
    public final boolean gte() {
        return this.Kyl;
    }

    @Override // com.tencent.mm.bt.b
    public final void gtf() {
        this.Kyl = false;
    }

    @Override // com.tencent.mm.bt.b
    public final h[] getFeatures() {
        AppMethodBeat.i(9298);
        h[] features = this.Kyf.getFeatures();
        AppMethodBeat.o(9298);
        return features;
    }

    @Override // com.tencent.mm.bt.b
    public final z getSelectedFeatureListener() {
        AppMethodBeat.i(9299);
        AnonymousClass1 r0 = new z() {
            /* class com.tencent.mm.bt.a.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.api.z
            public final void a(h hVar) {
                AppMethodBeat.i(9279);
                Log.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", hVar);
                if (hVar == h.DEFAULT) {
                    a.this.Kyf.getBaseFooterView().setCurFeatureType(hVar);
                }
                a.this.Kyf.getBaseFooterView().hgl();
                if (a.this.Kyf.getSelectedFeatureListener() != null) {
                    a.this.Kyf.getSelectedFeatureListener().a(hVar);
                }
                if (hVar == h.CROP_VIDEO) {
                    a.this.Kyf.getFooterBg().setVisibility(8);
                }
                com.tencent.mm.e.b bVar = a.this.Kyg.get(hVar);
                if (bVar == null) {
                    AppMethodBeat.o(9279);
                    return;
                }
                if (bVar.dbG && !bVar.isAlive()) {
                    bVar.onAlive();
                }
                if (bVar.XS() != com.tencent.mm.e.a.DEFAULT) {
                    bVar.setOneFingerMoveEnable(false);
                }
                bVar.XV();
                a.this.Kyr = bVar;
                switch (AnonymousClass7.Kyu[hVar.ordinal()]) {
                    case 1:
                        if (!a.this.Kyf.getBaseFooterView().hgg()) {
                            ((EditText) a.this.Kyf.getTextEditView().findViewById(R.id.ik7)).setTextColor(com.tencent.mm.view.footer.a.RoQ[0]);
                            a.this.Ar(true);
                            a.this.Kyf.setFooterVisible(false);
                        }
                        a.this.Kyp = hVar;
                        break;
                    case 2:
                        a.this.Kyf.setActionBarVisible(false);
                        a.this.Kyf.setFooterVisible(false);
                        a.this.Kyf.DC(false);
                        a.this.Kyp = hVar;
                        break;
                    case 3:
                        a.this.Kyo = a.this.Kyp;
                        break;
                    default:
                        a.this.Kyp = hVar;
                        break;
                }
                a.this.Kyf.getBaseFooterView().setCurFeatureType(hVar);
                AppMethodBeat.o(9279);
            }

            @Override // com.tencent.mm.api.z
            public final void a(h hVar, int i2, Object obj) {
                float f2;
                com.tencent.mm.z.a alD;
                AppMethodBeat.i(163137);
                Log.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", hVar, Integer.valueOf(i2));
                if (a.this.Kyf.getSelectedFeatureListener() != null) {
                    a.this.Kyf.getSelectedFeatureListener().a(hVar, i2, obj);
                }
                a.this.Kyr = a.this.Kyg.get(hVar);
                if (a.this.gti().XS() == com.tencent.mm.e.a.DEFAULT) {
                    AppMethodBeat.o(163137);
                    return;
                }
                if (a.this.Kyf.getFooterBg().getVisibility() == 8) {
                    a.this.Kyf.getFooterBg().setVisibility(0);
                }
                switch (AnonymousClass7.Kyu[hVar.ordinal()]) {
                    case 3:
                        com.tencent.mm.e.c cVar = (com.tencent.mm.e.c) a.this.gti();
                        if (i2 == 0) {
                            cVar.dsG++;
                            cVar.dsp.cancel();
                            if (cVar.dsE != null) {
                                cVar.dsE.cancel();
                            }
                            Matrix matrix = new Matrix();
                            matrix.postRotate(-90.0f, (float) cVar.dgS.centerX(), (float) cVar.dgS.centerY());
                            if (cVar.dsF.isEmpty()) {
                                cVar.dsF.set(cVar.dgS);
                            }
                            RectF rectF = new RectF(cVar.dsF);
                            matrix.mapRect(rectF);
                            float width = (1.0f * ((float) cVar.dsl.width())) / rectF.width();
                            float height = (1.0f * ((float) cVar.dsl.height())) / rectF.height();
                            if (width >= height) {
                                width = height;
                            }
                            matrix.postScale(width, width, (float) cVar.dgS.centerX(), (float) cVar.dgS.centerY());
                            rectF.set(cVar.dsF);
                            matrix.mapRect(rectF);
                            cVar.dsF.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                            float centerX = (float) cVar.dgS.centerX();
                            float centerY = (float) cVar.dgS.centerY();
                            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("rotation", 0, -90), PropertyValuesHolder.ofInt("deltaX", 0, cVar.dsl.centerX() - ((int) centerX)), PropertyValuesHolder.ofInt("deltaY", 0, cVar.dsl.centerY() - ((int) centerY)));
                            ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(centerX, centerY, width) {
                                /* class com.tencent.mm.e.c.AnonymousClass10 */
                                float dhm = ((float) Math.pow((double) this.dsJ, 0.0833333358168602d));
                                final /* synthetic */ float dsJ;
                                int dsN = 0;
                                float dsO;
                                float dsP = 0.0f;
                                float dsQ;
                                float dsR = 0.0f;
                                float dsS = this.dsU;
                                float dsT = this.dsV;
                                final /* synthetic */ float dsU;
                                final /* synthetic */ float dsV;
                                int scaleCount = 0;

                                {
                                    this.dsU = r8;
                                    this.dsV = r9;
                                    this.dsJ = r10;
                                    AppMethodBeat.i(204722);
                                    AppMethodBeat.o(204722);
                                }

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    AppMethodBeat.i(204723);
                                    if (this.scaleCount < 12) {
                                        c.this.getMainMatrix().postScale(this.dhm, this.dhm, ((float) c.this.dgS.centerX()) + this.dsP, ((float) c.this.dgS.centerY()) + this.dsR);
                                        c.this.dsg.postScale(this.dhm, this.dhm, ((float) c.this.dgS.centerX()) + this.dsP, ((float) c.this.dgS.centerY()) + this.dsR);
                                        this.scaleCount++;
                                    }
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
                                    int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
                                    int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
                                    c.this.getMainMatrix().postRotate((float) (intValue - this.dsN), this.dsU + this.dsP, this.dsV + this.dsR);
                                    c.this.dsg.postRotate((float) (intValue - this.dsN), this.dsU + this.dsP, this.dsV + this.dsR);
                                    RectF rectF = new RectF();
                                    rectF.set(c.this.dgS);
                                    c.this.dsg.mapRect(rectF);
                                    this.dsS += ((float) intValue2) - this.dsO;
                                    this.dsT += ((float) intValue3) - this.dsQ;
                                    this.dsP = this.dsS - rectF.centerX();
                                    this.dsR = this.dsT - rectF.centerY();
                                    c.this.getMainMatrix().postTranslate(this.dsP, this.dsR);
                                    c.this.dsg.postTranslate(this.dsP, this.dsR);
                                    c.this.Yb();
                                    this.dsN = intValue;
                                    this.dsO = (float) intValue2;
                                    this.dsQ = (float) intValue3;
                                    AppMethodBeat.o(204723);
                                }
                            });
                            ofPropertyValuesHolder.addListener(new Animator.AnimatorListener() {
                                /* class com.tencent.mm.e.c.AnonymousClass2 */

                                public final void onAnimationStart(Animator animator) {
                                    AppMethodBeat.i(204716);
                                    c.this.dsn = false;
                                    c.this.dsx = true;
                                    c.this.dso = true;
                                    AppMethodBeat.o(204716);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(204717);
                                    Log.i("MicroMsg.CropArtist", "onAnimationEnd");
                                    c.e(c.this);
                                    if (c.this.dsG == 0) {
                                        c.this.dso = false;
                                        RectF rectF = new RectF();
                                        rectF.set(c.this.dgS);
                                        c.this.dsg.mapRect(rectF);
                                        c.this.dsg.reset();
                                        c.this.dgS.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                        c.this.Ye();
                                    }
                                    c.a(c.this, 200, false, true);
                                    AppMethodBeat.o(204717);
                                }

                                public final void onAnimationCancel(Animator animator) {
                                }

                                public final void onAnimationRepeat(Animator animator) {
                                }
                            });
                            ofPropertyValuesHolder.setDuration(200L);
                            ofPropertyValuesHolder.start();
                            AppMethodBeat.o(163137);
                            return;
                        } else if (1 == i2) {
                            Log.i("MicroMsg.CropArtist", "[cancel]");
                            cVar.dsp.cancel();
                            if (cVar.dsE != null) {
                                cVar.dsE.cancel();
                            }
                            cVar.drS.gth().getBaseBoardView().u(cVar.drS.gth().getBaseBoardView().getRawBoardRect());
                            if (cVar.XU() == null || (alD = ((com.tencent.mm.cache.a) cVar.XU()).alD()) == null) {
                                f2 = 0.0f;
                            } else {
                                f2 = cVar.getRotation() - cVar.b(alD.mMatrix);
                                if (!alD.hof.isEmpty()) {
                                    cVar.drS.gth().getBaseBoardView().v(alD.hof);
                                }
                            }
                            cVar.drS.gth().getBaseBoardView().a(null, f2, true);
                            cVar.drS.gth().getActionBar().setVisibility(0);
                            a.this.Kyr = a.this.Kyg.get(a.this.Kyo);
                            a.this.Kyf.getBaseFooterView().setCurFeatureType(a.this.Kyo);
                            AppMethodBeat.o(163137);
                            return;
                        } else if (2 == i2) {
                            Log.i("MicroMsg.CropArtist", "[doCrop]");
                            if (cVar.dsE != null) {
                                cVar.dsE.cancel();
                            }
                            if (!cVar.dsp.dgZ) {
                                if (!cVar.dsp.isStarted) {
                                    cVar.dsp.cancel();
                                    cVar.dsp.play();
                                }
                                cVar.dsp.wY = new Animator.AnimatorListener() {
                                    /* class com.tencent.mm.e.c.AnonymousClass7 */

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        AppMethodBeat.i(204720);
                                        c.this.dsp.wY = null;
                                        c.c(c.this);
                                        AppMethodBeat.o(204720);
                                    }

                                    public final void onAnimationCancel(Animator animator) {
                                        c.this.dsp.wY = null;
                                    }

                                    public final void onAnimationRepeat(Animator animator) {
                                    }
                                };
                            } else {
                                cVar.dsp.wY = null;
                                cVar.Yg();
                            }
                            a.this.Kyr = a.this.Kyg.get(a.this.Kyo);
                            a.this.Kyf.getBaseFooterView().setCurFeatureType(a.this.Kyo);
                            AppMethodBeat.o(163137);
                            return;
                        } else if (3 == i2) {
                            Log.i("MicroMsg.CropArtist", "[reset]");
                            cVar.dsH = true;
                            cVar.dsp.cancel();
                            if (cVar.dsE != null) {
                                cVar.dsE.cancel();
                            }
                            cVar.dsF.setEmpty();
                            cVar.Yf();
                            cVar.dsx = false;
                            cVar.drS.gth().getBaseBoardView().u(cVar.dgS);
                            cVar.drS.gth().getBaseBoardView().a(new a.b() {
                                /* class com.tencent.mm.e.c.AnonymousClass9 */

                                @Override // com.tencent.mm.view.b.a.b
                                public final void Yh() {
                                    boolean z;
                                    AppMethodBeat.i(204721);
                                    if (!(c.this.getMainMatrix() == null || c.this.XU() == null)) {
                                        c.this.getMainMatrix().set(((com.tencent.mm.cache.a) c.this.XU()).gpz);
                                        if (c.this.dsq == null) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            c.a(c.this, 300, false, false);
                                        }
                                        c.a(c.this);
                                        c.this.Yc();
                                    }
                                    AppMethodBeat.o(204721);
                                }

                                @Override // com.tencent.mm.view.b.a.b
                                public final void onStart() {
                                    c.this.dsn = false;
                                }
                            }, cVar.getRotation(), true);
                            AppMethodBeat.o(163137);
                            return;
                        }
                        break;
                    case 4:
                        d dVar = (d) a.this.gti();
                        if (i2 != -1) {
                            dVar.mColor = a.this.Kyf.getBaseFooterView().getColor(i2);
                            AppMethodBeat.o(163137);
                            return;
                        }
                        dVar.Ya();
                        AppMethodBeat.o(163137);
                        return;
                    case 5:
                        com.tencent.mm.e.h hVar2 = (com.tencent.mm.e.h) a.this.gti();
                        if (i2 == 0) {
                            hVar2.dty = e.a.ONE;
                            AppMethodBeat.o(163137);
                            return;
                        } else if (1 == i2) {
                            hVar2.dty = e.a.TWO;
                            AppMethodBeat.o(163137);
                            return;
                        } else {
                            hVar2.Ya();
                            AppMethodBeat.o(163137);
                            return;
                        }
                    case 6:
                        com.tencent.mm.e.f fVar = (com.tencent.mm.e.f) a.this.gti();
                        float floatValue = ((Float) obj).floatValue();
                        com.tencent.mm.cache.e eVar = (com.tencent.mm.cache.e) fVar.XU();
                        if (eVar != null) {
                            eVar.gpC = i2;
                        }
                        com.tencent.mm.cache.e eVar2 = (com.tencent.mm.cache.e) fVar.XU();
                        if (eVar2 != null) {
                            eVar2.gpD = floatValue;
                        }
                        a.this.Kyf.getBaseBoardView().postInvalidate();
                        Log.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
                        break;
                }
                AppMethodBeat.o(163137);
            }

            @Override // com.tencent.mm.api.z
            public final void cH(boolean z) {
            }
        };
        AppMethodBeat.o(9299);
        return r0;
    }

    @Override // com.tencent.mm.bt.b
    public final void setActionBarCallback(j jVar) {
        this.Kyi = jVar;
    }

    @Override // com.tencent.mm.bt.b
    public final void setAutoShowFooterAndBar(boolean z) {
        this.Kyk = z;
    }

    @Override // com.tencent.mm.bt.b
    public final void onExit() {
        AppMethodBeat.i(9300);
        if (this.Kyi != null) {
            this.Kyi.onExit();
        }
        AppMethodBeat.o(9300);
    }

    @Override // com.tencent.mm.bt.b
    public final void onFinish() {
        AppMethodBeat.i(9302);
        if (this.Kyi != null) {
            this.Kyi.onFinish();
        }
        AppMethodBeat.o(9302);
    }

    @Override // com.tencent.mm.bt.b
    public final void a(Editable editable, int i2, int i3) {
        AppMethodBeat.i(9303);
        Ar(false);
        this.Kyf.setFooterVisible(true);
        com.tencent.mm.e.b gti = gti();
        if (gti.XS() == com.tencent.mm.e.a.EMOJI_AND_TEXT) {
            com.tencent.mm.e.e eVar = (com.tencent.mm.e.e) gti;
            EditText editText = (EditText) this.Kyf.getTextEditView().findViewById(R.id.ik7);
            if (editText.getTag() == null || !(editText.getTag() instanceof f)) {
                eVar.a(l.c(this.Kyf.getContext(), editable), i2, i3);
            } else {
                eVar.a((f) editText.getTag(), l.c(this.Kyf.getContext(), editable), i2, i3);
            }
            editText.setTag(null);
        }
        AppMethodBeat.o(9303);
    }

    @Override // com.tencent.mm.bt.b
    public final com.tencent.mm.view.a gth() {
        return this.Kyf;
    }

    @Override // com.tencent.mm.bt.b
    public final ab.a getConfig() {
        return this.diP;
    }

    @Override // com.tencent.mm.bt.b
    public final <T extends com.tencent.mm.e.b> T gti() {
        AppMethodBeat.i(9306);
        if (this.Kyr != null) {
            T t = (T) this.Kyr;
            AppMethodBeat.o(9306);
            return t;
        }
        Log.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
        T t2 = (T) com.tencent.mm.e.b.drW;
        AppMethodBeat.o(9306);
        return t2;
    }

    @Override // com.tencent.mm.bt.b
    public final void cW(float f2) {
        this.Kym = f2;
    }

    @Override // com.tencent.mm.bt.b
    public final float gtk() {
        return this.Kym;
    }

    @Override // com.tencent.mm.bt.b
    public final void a(u uVar, boolean z) {
        AppMethodBeat.i(9309);
        ThreadPool.post(new b(uVar, z), "onFinalGenerate_" + uVar.hashCode());
        AppMethodBeat.o(9309);
    }

    @Override // com.tencent.mm.bt.b
    public final void onDestroy() {
        AppMethodBeat.i(9310);
        Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.Kyh.clear();
        this.Kyg.clear();
        AppMethodBeat.o(9310);
    }

    @Override // com.tencent.mm.bt.b
    public final void gtl() {
        AppMethodBeat.i(204757);
        Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
        while (it.hasNext()) {
            com.tencent.mm.e.b next = it.next();
            next.drV = null;
            next.XU().clear();
        }
        AppMethodBeat.o(204757);
    }

    @Override // com.tencent.mm.bt.b
    public final void ate() {
        AppMethodBeat.i(9311);
        Log.i("MicroMsg.DrawingPresenter", "[onLayout],%s", Boolean.valueOf(this.Kyq));
        if (!this.Kyq) {
            this.Kyq = true;
            Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
            while (it.hasNext()) {
                com.tencent.mm.e.b next = it.next();
                if (ArtistCacheManager.alA().b(next.XS())) {
                    next.onAlive();
                    next.cT(true);
                    Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", next.XS());
                }
            }
            if (this.Kyf.getBaseBoardView().hgb()) {
                this.Kyf.getBaseBoardView().hgc();
                this.Kyf.getBaseBoardView().invalidate();
            }
        }
        AppMethodBeat.o(9311);
    }

    @Override // com.tencent.mm.bt.b
    public final void onAttachedToWindow() {
        AppMethodBeat.i(9312);
        Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
        if (!this.Kyq) {
            this.Kyq = true;
            Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
            while (it.hasNext()) {
                com.tencent.mm.e.b next = it.next();
                if (ArtistCacheManager.alA().b(next.XS())) {
                    next.onAlive();
                    next.cT(true);
                    Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", next.XS());
                }
            }
            if (this.Kyf.getBaseBoardView().hgb()) {
                this.Kyf.getBaseBoardView().hgc();
                this.Kyf.getBaseBoardView().invalidate();
            }
        }
        AppMethodBeat.o(9312);
    }

    @Override // com.tencent.mm.bt.b
    public final Bitmap gtm() {
        return this.Kyj;
    }

    @Override // com.tencent.mm.bt.b
    public final boolean gtn() {
        AppMethodBeat.i(9313);
        if (gti().XS() == com.tencent.mm.e.a.CROP_PHOTO || !this.Kyk) {
            AppMethodBeat.o(9313);
            return false;
        }
        AppMethodBeat.o(9313);
        return true;
    }

    @Override // com.tencent.mm.bt.b
    public final <T extends com.tencent.mm.e.b> T c(h hVar) {
        AppMethodBeat.i(9314);
        T t = (T) this.Kyg.get(hVar);
        AppMethodBeat.o(9314);
        return t;
    }

    @Override // com.tencent.mm.bt.b
    public final void c(r rVar) {
        AppMethodBeat.i(9315);
        com.tencent.mm.e.e eVar = (com.tencent.mm.e.e) c(h.EMOJI);
        if (eVar != null) {
            eVar.b(rVar);
        }
        AppMethodBeat.o(9315);
    }

    @Override // com.tencent.mm.bt.b
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(9317);
        Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
        while (it.hasNext()) {
            com.tencent.mm.e.b next = it.next();
            if (next.isAlive()) {
                if (gti().XS() == next.XS()) {
                    next.onDraw(canvas);
                } else {
                    canvas.save();
                    canvas.clipRect(this.Kyf.getBaseBoardView().getAliveRect());
                    next.d(canvas);
                    canvas.restore();
                }
            }
        }
        AppMethodBeat.o(9317);
    }

    @Override // com.tencent.mm.bt.b
    public final com.tencent.mm.cache.f a(com.tencent.mm.e.a aVar) {
        AppMethodBeat.i(9318);
        ArtistCacheManager alA = ArtistCacheManager.alA();
        String str = this.diP.path;
        if (TextUtils.isEmpty(str)) {
            if (ArtistCacheManager.gpr.containsKey(alA.gpt)) {
                com.tencent.mm.cache.f c2 = ArtistCacheManager.gpr.get(alA.gpt).c(aVar);
                AppMethodBeat.o(9318);
                return c2;
            }
            Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", alA.gpt);
            AppMethodBeat.o(9318);
            return null;
        } else if (ArtistCacheManager.gpr.containsKey(str)) {
            com.tencent.mm.cache.f c3 = ArtistCacheManager.gpr.get(str).c(aVar);
            AppMethodBeat.o(9318);
            return c3;
        } else {
            Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", str);
            AppMethodBeat.o(9318);
            return null;
        }
    }

    private void gto() {
        boolean z;
        AppMethodBeat.i(9319);
        this.Kyh.clear();
        this.Kyg.clear();
        this.Kyg.put(h.DEFAULT, com.tencent.mm.e.b.drW);
        h[] features = this.Kyf.getFeatures();
        for (h hVar : features) {
            com.tencent.mm.e.b bVar = null;
            switch (hVar) {
                case TEXT:
                case EMOJI:
                    Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.tencent.mm.e.b next = it.next();
                            if (next.XS() == com.tencent.mm.e.a.EMOJI_AND_TEXT) {
                                z = true;
                                bVar = next;
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (!z) {
                        bVar = new com.tencent.mm.e.e();
                        ((com.tencent.mm.e.e) bVar).dti = new C0283a();
                        break;
                    }
                    break;
                case CROP_PHOTO:
                    bVar = new com.tencent.mm.e.c();
                    break;
                case DOODLE:
                    bVar = new d();
                    break;
                case MOSAIC:
                    bVar = new com.tencent.mm.e.h();
                    break;
                case FILTER:
                    bVar = new com.tencent.mm.e.f();
                    break;
            }
            if (bVar != null) {
                if (!this.Kyg.containsKey(hVar)) {
                    this.Kyg.put(hVar, bVar);
                }
                if (!this.Kyh.contains(bVar)) {
                    this.Kyh.add(bVar);
                    bVar.a(this, this.Kyf.getBaseBoardView().getMainMatrix(), this.Kyf.getBaseBoardView().getAliveRect());
                }
            }
        }
        Collections.sort(this.Kyh, new Comparator<com.tencent.mm.e.b>() {
            /* class com.tencent.mm.bt.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(com.tencent.mm.e.b bVar, com.tencent.mm.e.b bVar2) {
                AppMethodBeat.i(9281);
                int i2 = bVar.XS().value - bVar2.XS().value;
                AppMethodBeat.o(9281);
                return i2;
            }
        });
        Log.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", Integer.valueOf(this.Kyg.size() - 1));
        AppMethodBeat.o(9319);
    }

    class b implements Runnable {
        u Kyy;
        boolean Kyz;

        b(u uVar, boolean z) {
            this.Kyy = uVar;
            this.Kyz = z;
        }

        public final void run() {
            Bitmap bitmap;
            Rect aR;
            AppMethodBeat.i(9295);
            try {
                Iterator<com.tencent.mm.e.b> it = a.this.Kyh.iterator();
                while (it.hasNext()) {
                    it.next().XW();
                }
                Bitmap bitmap2 = null;
                if (!a.this.Kyf.getBaseBoardView().hgb()) {
                    int width = a.this.Kyf.getBaseBoardView().getAliveRect().width();
                    int height = a.this.Kyf.getBaseBoardView().getAliveRect().height();
                    if (width > 0 && height > 0) {
                        bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    }
                    bitmap = bitmap2;
                } else {
                    bitmap = a.this.Kyj;
                }
                if (bitmap == null) {
                    this.Kyy.onError(new NullPointerException("bitmap is null!"));
                    try {
                        Iterator<com.tencent.mm.e.b> it2 = a.this.Kyh.iterator();
                        while (it2.hasNext()) {
                            it2.next().onFinish();
                        }
                        a.this.onDestroy();
                        AppMethodBeat.o(9295);
                    } catch (Exception e2) {
                        AppMethodBeat.o(9295);
                    }
                } else {
                    Canvas canvas = new Canvas(bitmap);
                    Iterator<com.tencent.mm.e.b> it3 = a.this.Kyh.iterator();
                    while (it3.hasNext()) {
                        it3.next().XU().e(canvas);
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapUtil.decodeFile(a.this.diP.path, options);
                    float height2 = (1.0f * ((float) options.outHeight)) / ((float) bitmap.getHeight());
                    float width2 = (1.0f * ((float) options.outWidth)) / ((float) bitmap.getWidth());
                    if (a.this.outputHeight > 0 && a.this.outputWidth > 0) {
                        height2 = (1.0f * ((float) a.this.outputHeight)) / ((float) bitmap.getHeight());
                        width2 = (1.0f * ((float) a.this.outputWidth)) / ((float) bitmap.getWidth());
                    }
                    if (height2 <= width2) {
                        height2 = width2;
                    }
                    if (height2 == 0.0f) {
                        height2 = 1.0f;
                    }
                    float b2 = a.this.Kyf.getBaseBoardView().b(a.this.Kyf.getBaseBoardView().getMainMatrix());
                    Matrix matrix = new Matrix();
                    matrix.postScale(height2, height2, 0.0f, 0.0f);
                    matrix.postRotate(-b2);
                    if (a.this.Kym > 0.0f) {
                        aR = aR(bitmap);
                        float width3 = (float) ((((double) aR.width()) * 1.0d) / ((double) aR.height()));
                        Log.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s ratio:%f", aR, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Float.valueOf(width3));
                        if (((double) width3) < ((double) a.this.Kym) - 0.06d || ((double) width3) > ((double) a.this.Kym) + 0.06d) {
                            if (a.this.Kym > width3) {
                                int centerY = aR.centerY();
                                int width4 = (int) ((((float) aR.width()) * 1.0f) / a.this.Kym);
                                Log.i("MicroMsg.DrawingPresenter", "clipRect.width() : " + aR.width() + " new height:" + width4);
                                aR.top = centerY - (width4 / 2);
                                aR.bottom = centerY + (width4 / 2);
                                Log.i("MicroMsg.DrawingPresenter", "top :" + aR.top + " bottom:" + aR.bottom);
                            } else {
                                int centerX = aR.centerX();
                                int height3 = (int) (((float) aR.height()) * 1.0f * a.this.Kym);
                                Log.i("MicroMsg.DrawingPresenter", "clipRect.height() : " + aR.height() + " new width:" + height3);
                                aR.left = centerX - (height3 / 2);
                                aR.right = centerX + (height3 / 2);
                                Log.i("MicroMsg.DrawingPresenter", "left :" + aR.left + " right:" + aR.right + " cropRectRatio:" + a.this.Kym);
                            }
                        }
                        Log.i("MicroMsg.DrawingPresenter", "ratio clipRect :" + ((((float) aR.width()) * 1.0f) / ((float) aR.height())));
                    } else {
                        aR = aR(bitmap);
                    }
                    final Bitmap a2 = a(bitmap, aR, b2, options, matrix);
                    com.tencent.f.h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.bt.a.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(204753);
                            b.this.Kyy.a(a2, b.this.Kyz);
                            AppMethodBeat.o(204753);
                        }
                    });
                    try {
                        Iterator<com.tencent.mm.e.b> it4 = a.this.Kyh.iterator();
                        while (it4.hasNext()) {
                            it4.next().onFinish();
                        }
                        a.this.onDestroy();
                        AppMethodBeat.o(9295);
                    } catch (Exception e3) {
                        AppMethodBeat.o(9295);
                    }
                }
            } catch (Exception e4) {
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.bt.a.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(204754);
                        b.this.Kyy.onError(e4);
                        AppMethodBeat.o(204754);
                    }
                });
                try {
                    Iterator<com.tencent.mm.e.b> it5 = a.this.Kyh.iterator();
                    while (it5.hasNext()) {
                        it5.next().onFinish();
                    }
                    a.this.onDestroy();
                    AppMethodBeat.o(9295);
                } catch (Exception e5) {
                    AppMethodBeat.o(9295);
                }
            } catch (Throwable th) {
                try {
                    Iterator<com.tencent.mm.e.b> it6 = a.this.Kyh.iterator();
                    while (it6.hasNext()) {
                        it6.next().onFinish();
                    }
                    a.this.onDestroy();
                } catch (Exception e6) {
                }
                AppMethodBeat.o(9295);
                throw th;
            }
        }

        private static Bitmap a(Bitmap bitmap, Rect rect, float f2, BitmapFactory.Options options, Matrix matrix) {
            Bitmap createBitmap;
            AppMethodBeat.i(9296);
            try {
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                } else {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (OutOfMemoryError e2) {
                Log.printErrStackTrace("MicroMsg.DrawingPresenter", e2, "", new Object[0]);
                float f3 = 1920.0f / ((float) options.outHeight);
                float f4 = 1920.0f / ((float) options.outWidth);
                if (f3 <= f4) {
                    f3 = f4;
                }
                matrix.reset();
                matrix.postScale(f3, f3, 0.0f, 0.0f);
                matrix.postRotate(-f2);
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                } else {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
            AppMethodBeat.o(9296);
            return createBitmap;
        }

        private Rect aR(Bitmap bitmap) {
            AppMethodBeat.i(261728);
            Rect rect = new Rect(a.this.Kyf.getBaseBoardView().getAliveRect());
            Log.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", rect, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            if (rect.bottom < 0) {
                rect.bottom = 0;
            }
            if (rect.right < 0) {
                rect.right = 0;
            }
            if (rect.bottom > bitmap.getHeight()) {
                rect.bottom = bitmap.getHeight();
            }
            if (rect.right > bitmap.getWidth()) {
                rect.right = bitmap.getWidth();
            }
            AppMethodBeat.o(261728);
            return rect;
        }
    }

    /* renamed from: com.tencent.mm.bt.a$a  reason: collision with other inner class name */
    public class C0283a implements com.tencent.mm.af.a {
        View Kyv = a.this.Kyf.getRubbishView();
        TextView Kyw = ((TextView) this.Kyv.findViewById(R.id.h9u));
        ImageView Kyx = ((ImageView) this.Kyv.findViewById(R.id.h9s));

        public C0283a() {
            AppMethodBeat.i(9289);
            AppMethodBeat.o(9289);
        }

        @Override // com.tencent.mm.af.a
        public final void at(float f2) {
            AppMethodBeat.i(9290);
            Log.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", Float.valueOf(f2));
            this.Kyv.setActivated(true);
            this.Kyw.setText(a.this.Kyf.getContext().getString(R.string.g_o));
            this.Kyx.setImageDrawable(ar.m(a.this.Kyf.getContext(), R.raw.icons_filled_delete_on, -1));
            AppMethodBeat.o(9290);
        }

        @Override // com.tencent.mm.af.a
        public final void aBB() {
            AppMethodBeat.i(9291);
            Log.i("MicroMsg.DrawingPresenter", "[onUnReach]");
            this.Kyv.setActivated(false);
            this.Kyx.setImageDrawable(ar.m(a.this.Kyf.getContext(), R.raw.icons_filled_delete, -1));
            this.Kyw.setText(a.this.Kyf.getContext().getString(R.string.g_p));
            AppMethodBeat.o(9291);
        }

        @Override // com.tencent.mm.af.a
        public final void onShow() {
            AppMethodBeat.i(9292);
            a.a(a.this, true);
            if (a.this.Kyn != null) {
                a.this.Kyn.l(Boolean.TRUE);
            }
            AppMethodBeat.o(9292);
        }

        @Override // com.tencent.mm.af.a
        public final void onHide() {
            AppMethodBeat.i(9293);
            a.a(a.this, false);
            AppMethodBeat.o(9293);
        }

        @Override // com.tencent.mm.af.a
        public final void a(f fVar) {
            AppMethodBeat.i(9294);
            EditText editText = (EditText) a.this.Kyf.getTextEditView().findViewById(R.id.ik7);
            editText.setTag(fVar);
            if (a.this.Kyn != null) {
                a.this.Kyn.b(fVar);
                AppMethodBeat.o(9294);
                return;
            }
            editText.setText(fVar.hoI);
            Switch r1 = (Switch) a.this.Kyf.findViewById(R.id.a37);
            SelectColorBar selectColorBar = (SelectColorBar) a.this.Kyf.findViewById(R.id.hhf);
            r1.setChecked(fVar.mBgColor != 0);
            if (r1.isChecked()) {
                selectColorBar.setSelectColor(fVar.mBgColor);
            } else {
                selectColorBar.setSelectColor(fVar.mColor);
            }
            editText.setTextColor(fVar.mColor);
            editText.setTag(fVar);
            a.this.Ar(true);
            AppMethodBeat.o(9294);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Ar(boolean z) {
        AppMethodBeat.i(9320);
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.Kyf.getContext(), R.anim.dq);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.bt.a.AnonymousClass3 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9283);
                    a.this.Kyf.getTextEditView().setVisibility(0);
                    EditText editText = (EditText) a.this.Kyf.getTextEditView().findViewById(R.id.ik7);
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    a.this.Kyf.getSelectedFeatureListener().cH(true);
                    ((SelectColorBar) a.this.Kyf.findViewById(R.id.hhf)).setSelectColor(editText.getCurrentTextColor());
                    a.this.Kyf.getActionBar().post(new Runnable() {
                        /* class com.tencent.mm.bt.a.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(9282);
                            a.this.Kyf.getActionBar().setVisibility(0);
                            AppMethodBeat.o(9282);
                        }
                    });
                    AppMethodBeat.o(9283);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.Kyf.getTextEditView().startAnimation(loadAnimation);
            AppMethodBeat.o(9320);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.Kyf.getContext(), R.anim.f6do);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.bt.a.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(9284);
                a.this.Kyf.getSelectedFeatureListener().cH(false);
                AppMethodBeat.o(9284);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(9285);
                ((EditText) a.this.Kyf.getTextEditView().findViewById(R.id.ik7)).setText("");
                a.this.Kyf.getTextEditView().setVisibility(8);
                AppMethodBeat.o(9285);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Kyf.getTextEditView().startAnimation(loadAnimation2);
        AppMethodBeat.o(9320);
    }

    @Override // com.tencent.mm.bt.b
    public final boolean Ul() {
        AppMethodBeat.i(9301);
        if (this.Kyf.getTextEditView().getVisibility() == 0) {
            Ar(false);
            this.Kyf.setFooterVisible(true);
            AppMethodBeat.o(9301);
            return true;
        } else if (this.Kyf.getChatFooterPanel() == null || this.Kyf.getChatFooterPanel().getVisibility() != 0) {
            AppMethodBeat.o(9301);
            return false;
        } else {
            this.Kyf.DC(true);
            this.Kyf.setFooterVisible(true);
            AppMethodBeat.o(9301);
            return true;
        }
    }

    @Override // com.tencent.mm.bt.b
    public final void gtg() {
        AppMethodBeat.i(9304);
        this.Kyf.setFooterVisible(true);
        Ar(false);
        AppMethodBeat.o(9304);
    }

    @Override // com.tencent.mm.bt.b
    public final float getInitScale() {
        AppMethodBeat.i(9307);
        float initScale = this.Kyf.getBaseBoardView().getInitScale();
        AppMethodBeat.o(9307);
        return initScale;
    }

    @Override // com.tencent.mm.bt.b
    public final void setInitScale(float f2) {
        AppMethodBeat.i(204756);
        this.Kyf.getBaseBoardView().setInitScale(f2);
        AppMethodBeat.o(204756);
    }

    @Override // com.tencent.mm.bt.b
    public final float getCurScale() {
        AppMethodBeat.i(9308);
        float curScale = this.Kyf.getBaseBoardView().getCurScale();
        AppMethodBeat.o(9308);
        return curScale;
    }

    @Override // com.tencent.mm.bt.b
    public final boolean R(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(9316);
        if (!(gti().XS() == com.tencent.mm.e.a.CROP_PHOTO || gti().XS() == com.tencent.mm.e.a.CROP_VIDEO)) {
            com.tencent.mm.e.b bVar = null;
            if (this.Kyg.containsKey(h.TEXT)) {
                bVar = this.Kyg.get(h.TEXT);
            } else if (this.Kyg.containsKey(h.EMOJI)) {
                bVar = this.Kyg.get(h.EMOJI);
            }
            if (bVar != null) {
                z2 = bVar.q(motionEvent);
            }
            if (z2) {
                this.Kyr = bVar;
            }
        }
        if (!z2) {
            this.Kyr = this.Kyg.get(this.Kyf.getBaseFooterView().getCurFeatureType());
            Iterator<com.tencent.mm.e.b> it = this.Kyh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mm.e.b next = it.next();
                if (next.XS() != com.tencent.mm.e.a.EMOJI_AND_TEXT && next.q(motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = z2;
        AppMethodBeat.o(9316);
        return z;
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        AppMethodBeat.i(261729);
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(aVar.Kyf.getContext(), R.anim.dq);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.bt.a.AnonymousClass5 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9286);
                    a.this.Kyf.getRubbishView().setVisibility(0);
                    AppMethodBeat.o(9286);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            aVar.Kyf.getRubbishView().startAnimation(loadAnimation);
            AppMethodBeat.o(261729);
            return;
        }
        aVar.Kyf.getRubbishView().setAlpha(0.82f);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(aVar.Kyf.getContext(), R.anim.f6do);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.bt.a.AnonymousClass6 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(9287);
                a.this.Kyf.getRubbishView().setVisibility(8);
                if (a.this.Kyn != null) {
                    a.this.Kyn.l(Boolean.FALSE);
                }
                AppMethodBeat.o(9287);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.Kyf.getRubbishView().startAnimation(loadAnimation2);
        AppMethodBeat.o(261729);
    }
}
