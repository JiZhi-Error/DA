package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.h;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class c extends a {
    private Bitmap RoX;
    private Bitmap RoY;
    private Bitmap RoZ;
    private Bitmap Rpa;
    private Bitmap Rpb;
    private Bitmap Rpc;
    private Bitmap Rpd;
    private Bitmap Rpe;
    private Bitmap Rpf;
    private Bitmap Rpg;
    private Bitmap Rph;
    private Bitmap Rpi;
    private Bitmap Rpj;
    private Bitmap Rpk;
    private Rect[] Rpl = new Rect[2];
    private Rect[] Rpm = new Rect[4];
    private boolean Rpn;
    private boolean Rpo;
    private boolean Rpp;
    private boolean Rpq;
    private boolean Rpr = true;
    private int Rps = -1;
    private Paint zbt;

    public c(Context context, b bVar) {
        super(context, bVar);
        AppMethodBeat.i(9405);
        AppMethodBeat.o(9405);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void hgh() {
        AppMethodBeat.i(9406);
        super.hgh();
        this.zbt = new Paint(1);
        this.zbt.setTextSize(getResources().getDimension(R.dimen.yj));
        this.Rpb = BitmapFactory.decodeResource(getResources(), R.drawable.cgv);
        this.Rpc = BitmapFactory.decodeResource(getResources(), R.drawable.cgu);
        this.Rpd = BitmapFactory.decodeResource(getResources(), R.drawable.cgx);
        this.Rpe = BitmapFactory.decodeResource(getResources(), R.drawable.cgw);
        this.RoY = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.mosaic_unselected));
        this.RoX = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.mosaic_selected));
        this.RoZ = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.crop_unselected));
        this.Rpa = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.crop_selected));
        this.Rpf = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.rotation_normal));
        this.Rpg = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.rotation_press));
        this.Rpi = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.sure_crop_press));
        this.Rph = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.sure_crop_normal));
        this.Rpj = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.cancel_crop_press));
        this.Rpk = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.cancel_crop_normal));
        AppMethodBeat.o(9406);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(9407);
        if (getCurFeatureType() != h.CROP_PHOTO) {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(9407);
            return;
        }
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(getDetailHeight(), 1073741824));
        hgj();
        AppMethodBeat.o(9407);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void A(Canvas canvas) {
        AppMethodBeat.i(9408);
        if (!this.RoR) {
            if (getCurFeatureType() != h.CROP_PHOTO) {
                super.A(canvas);
                AppMethodBeat.o(9408);
                return;
            }
            B(canvas);
        }
        AppMethodBeat.o(9408);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final Bitmap a(h hVar, boolean z) {
        if (hVar == h.CROP_PHOTO) {
            return z ? this.Rpa : this.RoZ;
        }
        if (hVar == h.MOSAIC) {
            return z ? this.RoX : this.RoY;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public int getDetailHeight() {
        AppMethodBeat.i(9409);
        int detailHeight = super.getDetailHeight();
        if (detailHeight == 0) {
            if (getCurFeatureType() == h.MOSAIC) {
                int dimension = (int) getResources().getDimension(R.dimen.a4_);
                AppMethodBeat.o(9409);
                return dimension;
            } else if (getCurFeatureType() == h.CROP_PHOTO) {
                int dimension2 = (int) (getResources().getDimension(R.dimen.a4a) + getResources().getDimension(R.dimen.yk));
                AppMethodBeat.o(9409);
                return dimension2;
            }
        }
        AppMethodBeat.o(9409);
        return detailHeight;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final boolean apX(int i2) {
        boolean z = true;
        AppMethodBeat.i(9410);
        boolean apX = super.apX(i2);
        switch (apW(i2)) {
            case CROP_PHOTO:
            case MOSAIC:
                break;
            default:
                z = apX;
                break;
        }
        AppMethodBeat.o(9410);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void mc(int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(9411);
        super.mc(i2, i3);
        switch (apW(this.oEI)) {
            case CROP_PHOTO:
                while (true) {
                    if (i4 < this.Rpm.length) {
                        Rect rect = this.Rpm[i4];
                        if (rect == null || !rect.contains(i2, i3)) {
                            i4++;
                        } else if (i4 == 0) {
                            this.Rpo = true;
                            AppMethodBeat.o(9411);
                            return;
                        } else if (i4 == 1) {
                            this.Rpn = true;
                            AppMethodBeat.o(9411);
                            return;
                        } else if (i4 == 2) {
                            this.Rpp = true;
                            AppMethodBeat.o(9411);
                            return;
                        } else if (i4 == 3) {
                            this.Rpq = true;
                            AppMethodBeat.o(9411);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(9411);
                return;
            case MOSAIC:
                for (int i5 = 0; i5 < this.Rpl.length; i5++) {
                    Rect rect2 = this.Rpl[i5];
                    if (rect2 == null) {
                        Log.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", Integer.valueOf(i5));
                    }
                    if (rect2 != null && rect2.contains(i2, i3)) {
                        this.Rps = i5;
                        AppMethodBeat.o(9411);
                        return;
                    }
                }
                AppMethodBeat.o(9411);
                return;
            default:
                AppMethodBeat.o(9411);
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void md(int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(9412);
        super.md(i2, i3);
        switch (apW(this.oEI)) {
            case CROP_PHOTO:
                int i5 = 0;
                while (this.Rpm != null && i5 < this.Rpm.length) {
                    Rect rect = this.Rpm[i5];
                    if (rect == null || !rect.contains(i2, i3)) {
                        i5++;
                    } else {
                        if ((i5 == 0 && this.Rpo) || ((i5 == 1 && this.Rpn) || ((i5 == 2 && this.Rpp) || (i5 == 3 && this.Rpq)))) {
                            getPresenter().getSelectedFeatureListener().a(h.CROP_PHOTO, i5, null);
                            this.RoI = this.oEI;
                        }
                        this.Rpo = false;
                        this.Rpn = false;
                        this.Rpp = false;
                        this.Rpq = false;
                        AppMethodBeat.o(9412);
                        return;
                    }
                }
                AppMethodBeat.o(9412);
                return;
            case MOSAIC:
                while (this.Rpl != null && i4 < this.Rpl.length) {
                    Rect rect2 = this.Rpl[i4];
                    if (rect2 == null || !rect2.contains(i2, i3) || i4 != this.Rps) {
                        i4++;
                    } else {
                        getPresenter().getSelectedFeatureListener().a(h.MOSAIC, i4, null);
                        this.RoI = this.oEI;
                        AppMethodBeat.o(9412);
                        return;
                    }
                }
                AppMethodBeat.o(9412);
                return;
            default:
                AppMethodBeat.o(9412);
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void hgj() {
        AppMethodBeat.i(9413);
        super.hgj();
        if (getCurFeatureType() == h.MOSAIC) {
            hgn();
            AppMethodBeat.o(9413);
            return;
        }
        if (getCurFeatureType() == h.CROP_PHOTO) {
            hgo();
        }
        AppMethodBeat.o(9413);
    }

    private void hgn() {
        AppMethodBeat.i(9414);
        if (this.Rpl == null) {
            this.Rpl = new Rect[2];
        }
        if (this.RoM == null) {
            this.RoM = new Rect();
        }
        float measuredWidth = ((float) ((((getMeasuredWidth() - getPaddingLeftAndRight()) - this.RoG.getWidth()) - this.Rpe.getWidth()) - this.Rpb.getWidth())) / 3.0f;
        int width = (int) (((float) (this.Rpd.getWidth() / 2)) + measuredWidth);
        int detailHeight = ((getDetailHeight() - this.Rpd.getWidth()) / 2) + (this.Rpd.getWidth() / 2);
        int width2 = this.Rpd.getWidth() * 2;
        this.Rpl[0] = new Rect(width - width2, detailHeight - width2, width + width2, detailHeight + width2);
        int width3 = (int) (measuredWidth + ((float) this.Rpd.getWidth()) + ((float) width));
        this.Rpl[1] = new Rect(width3 - width2, detailHeight - width2, width3 + width2, detailHeight + width2);
        int measuredWidth2 = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.RoG.getWidth() / 2);
        this.RoM.set(measuredWidth2 - this.RoG.getWidth(), 0, measuredWidth2 + this.RoG.getWidth(), getDetailHeight());
        AppMethodBeat.o(9414);
    }

    private void hgo() {
        AppMethodBeat.i(9415);
        if (this.Rpm == null) {
            this.Rpm = new Rect[4];
        }
        int dimension = (int) getResources().getDimension(R.dimen.yk);
        float dimension2 = ((float) dimension) + ((getResources().getDimension(R.dimen.a4a) / 2.0f) - ((float) (this.Rpk.getHeight() / 2)));
        int height = (int) (((float) ((dimension / 2) - (this.Rpg.getHeight() / 2))) + ((float) (this.Rpk.getHeight() / 2)));
        int paddingLeftAndRight = (int) (((1.0f * ((float) getPaddingLeftAndRight())) / 2.0f) + ((float) (this.Rpk.getHeight() / 2)));
        int height2 = this.Rpk.getHeight();
        this.Rpm[0] = new Rect(paddingLeftAndRight - height2, height - height2, paddingLeftAndRight + height2, height + height2);
        int height3 = (int) (dimension2 + ((float) (this.Rpk.getHeight() / 2)));
        this.Rpm[1] = new Rect(paddingLeftAndRight - height2, height3 - height2, paddingLeftAndRight + height2, height3 + height2);
        int measuredWidth = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.Rpk.getHeight() / 2);
        this.Rpm[2] = new Rect(measuredWidth - height2, height3 - height2, measuredWidth + height2, height3 + height2);
        int measuredWidth2 = getMeasuredWidth() / 2;
        this.Rpm[3] = new Rect(measuredWidth2 - height2, height3 - height2, measuredWidth2 + height2, height3 + height2);
        AppMethodBeat.o(9415);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void B(Canvas canvas) {
        AppMethodBeat.i(9416);
        super.B(canvas);
        if (getCurFeatureType() == h.MOSAIC) {
            Paint paint = new Paint();
            if (XX()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(160);
            }
            canvas.drawBitmap((!this.RoN || !XX()) ? this.RoG : this.RoH, (float) ((getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - this.RoG.getWidth()), (float) ((getDetailHeight() - this.RoG.getHeight()) / 2), paint);
            float measuredWidth = ((float) ((((getMeasuredWidth() - getPaddingLeftAndRight()) - this.RoG.getWidth()) - this.Rpe.getWidth()) - this.Rpb.getWidth())) / 3.0f;
            float detailHeight = (1.0f * ((float) (getDetailHeight() - this.Rpe.getHeight()))) / 2.0f;
            if (this.Rpr) {
                this.Rps = 0;
                this.Rpr = false;
            }
            if (this.Rps == 0) {
                canvas.drawBitmap(this.Rpc, measuredWidth, detailHeight, (Paint) null);
                canvas.drawBitmap(this.Rpd, measuredWidth + measuredWidth + ((float) this.Rpe.getWidth()), detailHeight, (Paint) null);
                AppMethodBeat.o(9416);
            } else if (this.Rps == 1) {
                canvas.drawBitmap(this.Rpb, measuredWidth, detailHeight, (Paint) null);
                canvas.drawBitmap(this.Rpe, measuredWidth + measuredWidth + ((float) this.Rpe.getWidth()), detailHeight, (Paint) null);
                AppMethodBeat.o(9416);
            } else {
                canvas.drawBitmap(this.Rpb, measuredWidth, detailHeight, (Paint) null);
                canvas.drawBitmap(this.Rpd, measuredWidth + measuredWidth + ((float) this.Rpe.getWidth()), detailHeight, (Paint) null);
                AppMethodBeat.o(9416);
            }
        } else {
            if (getCurFeatureType() == h.CROP_PHOTO) {
                int dimension = (int) getResources().getDimension(R.dimen.yk);
                canvas.drawLine(0.0f, (float) dimension, (float) getMeasuredWidth(), (float) dimension, this.RoP);
                float dimension2 = ((getResources().getDimension(R.dimen.a4a) / 2.0f) - ((float) (this.Rpk.getHeight() / 2))) + ((float) dimension);
                float paddingLeftAndRight = (1.0f * ((float) getPaddingLeftAndRight())) / 2.0f;
                float height = (float) ((dimension / 2) - (this.Rpg.getHeight() / 2));
                if (this.Rpo) {
                    canvas.drawBitmap(this.Rpg, paddingLeftAndRight, height, (Paint) null);
                } else {
                    canvas.drawBitmap(this.Rpf, paddingLeftAndRight, height, (Paint) null);
                }
                if (this.Rpp) {
                    canvas.drawBitmap(this.Rpi, (((float) getMeasuredWidth()) - paddingLeftAndRight) - ((float) this.Rpk.getWidth()), dimension2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.Rph, (((float) getMeasuredWidth()) - paddingLeftAndRight) - ((float) this.Rpk.getWidth()), dimension2, (Paint) null);
                }
                if (this.Rpn) {
                    canvas.drawBitmap(this.Rpj, paddingLeftAndRight, dimension2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.Rpk, paddingLeftAndRight, dimension2, (Paint) null);
                }
                float dimension3 = getResources().getDimension(R.dimen.yj) * 2.0f;
                float dimension4 = ((getResources().getDimension(R.dimen.yj) - 8.0f) / 2.0f) + (getResources().getDimension(R.dimen.a4a) / 2.0f) + ((float) dimension);
                float measuredWidth2 = (float) (getMeasuredWidth() / 2);
                if (this.Rpq) {
                    this.zbt.setColor(-1);
                    this.zbt.setAlpha(160);
                    canvas.drawText(getResources().getString(R.string.bjo), measuredWidth2 - (dimension3 / 2.0f), dimension4, this.zbt);
                    AppMethodBeat.o(9416);
                    return;
                } else if (XX()) {
                    this.zbt.setColor(-1);
                    this.zbt.setAlpha(255);
                    canvas.drawText(getResources().getString(R.string.bjo), measuredWidth2 - (dimension3 / 2.0f), dimension4, this.zbt);
                    AppMethodBeat.o(9416);
                    return;
                } else {
                    this.zbt.setColor(-1);
                    this.zbt.setAlpha(100);
                    canvas.drawText(getResources().getString(R.string.bjo), measuredWidth2 - (dimension3 / 2.0f), dimension4, this.zbt);
                }
            }
            AppMethodBeat.o(9416);
        }
    }
}
