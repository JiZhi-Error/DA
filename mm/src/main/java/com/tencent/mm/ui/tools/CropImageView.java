package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.f;
import java.util.Timer;
import java.util.TimerTask;

public class CropImageView extends ImageView {
    private boolean OVg = false;
    private Drawable OVh;
    private boolean QpO = true;
    private boolean QpP = false;
    private float QpQ;
    private float QpR;
    private PointF QpS = new PointF();
    float QpT = 0.0f;
    float QpU = 0.0f;
    boolean QpV = false;
    private boolean QpW = false;
    private boolean QpX = false;
    private boolean QpY = false;
    private boolean QpZ = false;
    private boolean Qqa = false;
    private boolean Qqb = false;
    private boolean Qqc = false;
    private float Qqd = 1.0f;
    private c Qqe = null;
    private boolean Qqf = false;
    private boolean Qqg = false;
    Timer Qqh;
    MMHandler Qqi = new MMHandler() {
        /* class com.tencent.mm.ui.tools.CropImageView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z;
            AppMethodBeat.i(143038);
            Log.d("MicroMsg.CropImageView", "on handler");
            if (message.what == 4659) {
                CropImageView.this.zoomIn();
            } else if (message.what == 4658) {
                CropImageView.this.zoomOut();
            } else if (message.what == 4660) {
                if (!(CropImageView.this.dfh == null || CropImageView.this.Qqe == null)) {
                    CropImageView.this.Qqe.cancel();
                    CropImageView.this.Qqe = null;
                }
            } else if (message.what == 4661) {
                MotionEvent motionEvent = (MotionEvent) message.obj;
                CropImageView.this.yKl = System.currentTimeMillis();
                CropImageView.this.QpW = false;
                if (motionEvent.getRawX() - CropImageView.this.QpQ > 10.0f || motionEvent.getRawY() - CropImageView.this.QpR > 10.0f || motionEvent.getRawX() - CropImageView.this.QpQ < -10.0f || motionEvent.getRawY() - CropImageView.this.QpR < -10.0f) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (CropImageView.this.yKl != 0 && currentTimeMillis - CropImageView.this.yKl < 300 && currentTimeMillis - CropImageView.this.yKl >= 0 && CropImageView.this.Qql != null) {
                        CropImageView.this.Qql.gXA();
                    }
                    CropImageView.this.yKl = 0;
                }
                f.a(CropImageView.this.QpS, CropImageView.this.xqp);
            }
            super.handleMessage(message);
            AppMethodBeat.o(143038);
        }
    };
    private b Qqj = null;
    MMHandler Qqk = new MMHandler() {
        /* class com.tencent.mm.ui.tools.CropImageView.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(143039);
            if (message.what != 4653) {
                CropImageView.o(CropImageView.this);
            } else if (!(CropImageView.this.dfh == null || CropImageView.this.Qqj == null)) {
                CropImageView.this.Qqj.cancel();
                CropImageView.this.Qqj = null;
            }
            super.handleMessage(message);
            AppMethodBeat.o(143039);
        }
    };
    private a Qql;
    private boolean Qqm = true;
    private float aTD;
    private float aTE;
    private View.OnTouchListener aZa = new View.OnTouchListener() {
        /* class com.tencent.mm.ui.tools.CropImageView.AnonymousClass3 */

        public final boolean onTouch(View view, final MotionEvent motionEvent) {
            AppMethodBeat.i(143041);
            if (!CropImageView.this.Qqm) {
                AppMethodBeat.o(143041);
                return false;
            } else if (CropImageView.this.xqp == null) {
                AppMethodBeat.o(143041);
                return false;
            } else {
                int action = motionEvent.getAction() & 255;
                Log.d("MicroMsg.CropImageView", "on touch : event type=" + action + ", isDownOnImg=" + CropImageView.this.QpW);
                if (CropImageView.this.QpW || action == 0) {
                    switch (action) {
                        case 0:
                            Log.d("MicroMsg.CropImageView", "action_down");
                            CropImageView.this.aTD = motionEvent.getRawX();
                            CropImageView.this.aTE = motionEvent.getRawY();
                            Log.d("MicroMsg.CropImageView", "lastX=" + CropImageView.this.aTD + ",lastY=" + CropImageView.this.aTE);
                            CropImageView.this.QpQ = CropImageView.this.aTD;
                            CropImageView.this.QpR = CropImageView.this.aTE;
                            Matrix imageMatrix = CropImageView.this.getImageMatrix();
                            RectF rectF = new RectF();
                            rectF.set(0.0f, 0.0f, (float) CropImageView.this.xqp.getWidth(), (float) CropImageView.this.xqp.getHeight());
                            imageMatrix.mapRect(rectF);
                            CropImageView.this.QpW = rectF.contains(CropImageView.this.aTD, CropImageView.this.aTE);
                            CropImageView.this.yKl = System.currentTimeMillis();
                            break;
                        case 1:
                            Log.d("MicroMsg.CropImageView", "action_up");
                            if (!CropImageView.this.Qqg) {
                                CropImageView.this.Qqg = true;
                                if (CropImageView.this.Qqh != null) {
                                    CropImageView.this.Qqh.cancel();
                                }
                                CropImageView.this.Qqh = new Timer();
                                CropImageView.this.Qqh.schedule(new TimerTask() {
                                    /* class com.tencent.mm.ui.tools.CropImageView.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(143040);
                                        if (CropImageView.this.Qqg) {
                                            Message message = new Message();
                                            message.what = 4661;
                                            message.obj = motionEvent;
                                            CropImageView.this.Qqi.sendMessage(message);
                                            CropImageView.this.Qqg = false;
                                        }
                                        AppMethodBeat.o(143040);
                                    }
                                }, 200);
                                break;
                            } else {
                                CropImageView.this.Qqg = false;
                                if (!CropImageView.this.Qqf) {
                                    CropImageView.this.Qqf = true;
                                    CropImageView.this.zoomIn();
                                    CropImageView.this.zoomIn();
                                    CropImageView.this.zoomIn();
                                    CropImageView.this.zoomIn();
                                    CropImageView.this.zoomIn();
                                    break;
                                } else {
                                    CropImageView.this.Qqf = false;
                                    CropImageView.this.zoomOut();
                                    CropImageView.this.zoomOut();
                                    CropImageView.this.zoomOut();
                                    CropImageView.this.zoomOut();
                                    CropImageView.this.zoomOut();
                                    break;
                                }
                            }
                        case 2:
                            Log.d("MicroMsg.CropImageView", "action_move");
                            if (CropImageView.this.QpV) {
                                Log.d("MicroMsg.CropImageView", "is valid mult down");
                                CropImageView.this.QpU = f.ah(motionEvent);
                                float f2 = CropImageView.this.QpU - CropImageView.this.QpT;
                                if (CropImageView.this.QpU > 5.0f && Math.abs(f2) > 5.0f) {
                                    f.a(CropImageView.this.QpS, motionEvent);
                                    Log.d("MicroMsg.CropImageView", "mX=" + CropImageView.this.QpS.x + ",mY=" + CropImageView.this.QpS.y);
                                    if (f2 > 0.0f) {
                                        Log.d("MicroMsg.CropImageView", "zoom in");
                                        CropImageView.this.zoomIn();
                                    } else {
                                        Log.d("MicroMsg.CropImageView", "zoom out");
                                        CropImageView.this.zoomOut();
                                    }
                                }
                                CropImageView.this.QpT = CropImageView.this.QpU;
                            }
                            if (!CropImageView.this.QpP) {
                                float rawX = motionEvent.getRawX() - CropImageView.this.aTD;
                                float rawY = motionEvent.getRawY() - CropImageView.this.aTE;
                                if (Math.abs(rawX) > 5.0f || Math.abs(rawY) > 5.0f) {
                                    CropImageView.this.getImageMatrix().postTranslate(rawX, rawY);
                                }
                                CropImageView.this.invalidate();
                            }
                            CropImageView.this.QpP = false;
                            CropImageView.this.aTD = motionEvent.getRawX();
                            CropImageView.this.aTE = motionEvent.getRawY();
                            break;
                        case 5:
                            Log.d("MicroMsg.CropImageView", "action_mult_down");
                            CropImageView.this.QpP = true;
                            CropImageView.this.QpT = f.ah(motionEvent);
                            if (CropImageView.this.QpT > 5.0f) {
                                CropImageView.this.QpV = true;
                                f.a(CropImageView.this.QpS, motionEvent);
                                AppMethodBeat.o(143041);
                                return true;
                            }
                            break;
                        case 6:
                            Log.d("MicroMsg.CropImageView", "action_mult_up");
                            CropImageView.this.QpV = false;
                            CropImageView.this.QpP = true;
                            AppMethodBeat.o(143041);
                            return true;
                    }
                    AppMethodBeat.o(143041);
                    return false;
                }
                AppMethodBeat.o(143041);
                return false;
            }
        }
    };
    int dQd = 0;
    private Timer dfh = new Timer(true);
    private float translateX = 0.0f;
    private float translateY = 0.0f;
    Bitmap xqp;
    private long yKl;

    public interface a {
        void gXA();
    }

    /* access modifiers changed from: package-private */
    public class c extends TimerTask {
        final /* synthetic */ CropImageView Qqn;

        public final void run() {
            AppMethodBeat.i(143043);
            Log.d("MicroMsg.CropImageView", "in timer task run");
            Message message = new Message();
            if (this.Qqn.QpY) {
                message.what = 4659;
            } else if (this.Qqn.QpX) {
                message.what = 4658;
            } else {
                message.what = 4660;
            }
            this.Qqn.Qqi.sendMessage(message);
            AppMethodBeat.o(143043);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends TimerTask {
        final /* synthetic */ CropImageView Qqn;

        public final void run() {
            AppMethodBeat.i(143042);
            Message message = new Message();
            if (this.Qqn.Qqb || this.Qqn.Qqc || this.Qqn.Qqa || this.Qqn.QpZ) {
                message.what = 4654;
            } else {
                message.what = 4653;
            }
            this.Qqn.Qqk.sendMessage(message);
            AppMethodBeat.o(143042);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143044);
        gXB();
        AppMethodBeat.o(143044);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(143045);
        this.OVg = false;
        this.xqp = bitmap;
        f.a(this.QpS, bitmap);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(143045);
    }

    public void setLimitZoomIn(boolean z) {
        this.QpO = z;
    }

    public void setEnableOprate(boolean z) {
        this.Qqm = z;
    }

    public Bitmap getBmp() {
        return this.xqp;
    }

    public void setOnShortClick(a aVar) {
        this.Qql = aVar;
    }

    public final void gXB() {
        AppMethodBeat.i(143046);
        setOnTouchListener(this.aZa);
        AppMethodBeat.o(143046);
    }

    public final void zoomIn() {
        AppMethodBeat.i(143047);
        this.Qqd *= 1.0666f;
        if (1.0f <= this.Qqd) {
            this.QpY = false;
        }
        if (1.6f < this.Qqd) {
            this.QpX = true;
        } else {
            this.QpX = false;
        }
        if (!this.QpO || 4.0f >= this.Qqd) {
            gXC();
            AppMethodBeat.o(143047);
            return;
        }
        this.Qqd = 4.0f;
        AppMethodBeat.o(143047);
    }

    private void gXC() {
        AppMethodBeat.i(143048);
        float f2 = this.QpS.x;
        float f3 = this.QpS.y;
        float[] fArr = {f2, f3};
        float[] fArr2 = {f2, f3};
        getImageMatrix().mapPoints(fArr2);
        getImageMatrix().postScale(1.0666f, 1.0666f);
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postTranslate((fArr2[0] - fArr[0]) / 2.0f, (fArr2[1] - fArr[1]) / 2.0f);
        setImageBitmap(this.xqp);
        invalidate();
        AppMethodBeat.o(143048);
    }

    public final void zoomOut() {
        AppMethodBeat.i(143049);
        this.Qqd *= 0.9375f;
        if (1.6f > this.Qqd) {
            this.QpX = false;
        }
        if (1.0f > this.Qqd) {
            this.QpY = true;
        } else {
            this.QpY = false;
        }
        if (0.4f > this.Qqd) {
            this.Qqd = 0.4f;
            AppMethodBeat.o(143049);
            return;
        }
        gXD();
        AppMethodBeat.o(143049);
    }

    private void gXD() {
        AppMethodBeat.i(143050);
        float f2 = this.QpS.x;
        float f3 = this.QpS.y;
        float[] fArr = {f2, f3};
        float[] fArr2 = {f2, f3};
        getImageMatrix().mapPoints(fArr2);
        getImageMatrix().postScale(0.9375f, 0.9375f);
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postTranslate((fArr2[0] - fArr[0]) / 2.0f, (fArr2[1] - fArr[1]) / 2.0f);
        setImageBitmap(this.xqp);
        invalidate();
        AppMethodBeat.o(143050);
    }

    public int getRotateCount() {
        return this.dQd;
    }

    public void setGifPath(String str) {
        AppMethodBeat.i(143051);
        try {
            this.OVg = true;
            this.OVh = com.tencent.mm.ui.g.b.c.nl(str, str);
            setImageDrawable(this.OVh);
            AppMethodBeat.o(143051);
        } catch (Exception e2) {
            this.OVg = false;
            AppMethodBeat.o(143051);
        }
    }

    public int getGifWidth() {
        AppMethodBeat.i(143052);
        if (!this.OVg || this.OVh == null) {
            int width = getWidth();
            AppMethodBeat.o(143052);
            return width;
        }
        int intrinsicWidth = this.OVh.getIntrinsicWidth();
        AppMethodBeat.o(143052);
        return intrinsicWidth;
    }

    public int getGifHeight() {
        AppMethodBeat.i(143053);
        if (!this.OVg || this.OVh == null) {
            int height = getHeight();
            AppMethodBeat.o(143053);
            return height;
        }
        int intrinsicHeight = this.OVh.getIntrinsicHeight();
        AppMethodBeat.o(143053);
        return intrinsicHeight;
    }

    static /* synthetic */ void o(CropImageView cropImageView) {
        AppMethodBeat.i(143054);
        if (cropImageView.QpZ) {
            cropImageView.translateX -= -20.0f;
            if (cropImageView.translateX > 0.0f) {
                cropImageView.QpZ = false;
            }
            cropImageView.getImageMatrix().postTranslate(-20.0f, 0.0f);
        }
        if (cropImageView.Qqa) {
            cropImageView.translateX -= 20.0f;
            if (cropImageView.translateX < 0.0f) {
                cropImageView.Qqa = false;
            }
            cropImageView.getImageMatrix().postTranslate(20.0f, 0.0f);
        }
        if (cropImageView.Qqb) {
            cropImageView.translateY -= 20.0f;
            if (cropImageView.translateY < 0.0f) {
                cropImageView.Qqb = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, 20.0f);
        }
        if (cropImageView.Qqc) {
            cropImageView.translateY -= -20.0f;
            if (cropImageView.translateY > 0.0f) {
                cropImageView.Qqc = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, -20.0f);
        }
        cropImageView.setImageBitmap(cropImageView.xqp);
        cropImageView.invalidate();
        AppMethodBeat.o(143054);
    }
}
