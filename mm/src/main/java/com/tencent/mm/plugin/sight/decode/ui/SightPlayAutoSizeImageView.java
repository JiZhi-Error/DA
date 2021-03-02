package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView extends ImageView implements com.tencent.mm.plugin.sight.decode.a.a {
    private b Dnr;

    static final class a extends b {
        private WeakReference<SightPlayAutoSizeImageView> Dns;

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final int eVx() {
            return R.anim.eh;
        }

        public a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
            super(0, sightPlayAutoSizeImageView);
            AppMethodBeat.i(28625);
            this.Dns = new WeakReference<>(sightPlayAutoSizeImageView);
            AppMethodBeat.o(28625);
        }

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final void eo(int i2, int i3) {
        }

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final void at(Bitmap bitmap) {
            AppMethodBeat.i(28626);
            SightPlayAutoSizeImageView sightPlayAutoSizeImageView = this.Dns.get();
            if (sightPlayAutoSizeImageView == null) {
                Log.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.o(28626);
                return;
            }
            sightPlayAutoSizeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            sightPlayAutoSizeImageView.setImageBitmap(bitmap);
            AppMethodBeat.o(28626);
        }
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(28627);
        this.Dnr = new a(this);
        AppMethodBeat.o(28627);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public String getVideoPath() {
        return this.Dnr.cJp;
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void clear() {
        AppMethodBeat.i(28628);
        this.Dnr.clear();
        AppMethodBeat.o(28628);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void e(String str, boolean z, int i2) {
        AppMethodBeat.i(169763);
        this.Dnr.cd(str, z);
        AppMethodBeat.o(169763);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setPosition(int i2) {
        this.Dnr.position = i2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(28631);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.Dnr.clear();
        EventCenter.instance.removeListener(this.Dnr.eVB());
        AppMethodBeat.o(28631);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(28632);
        Log.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        EventCenter.instance.addListener(this.Dnr.eVB());
        AppMethodBeat.o(28632);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setDrawableWidth(int i2) {
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(28633);
        setImageBitmap(bitmap);
        AppMethodBeat.o(28633);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void eVw() {
        AppMethodBeat.i(28634);
        setImageBitmap(null);
        setImageResource(R.drawable.bjn);
        AppMethodBeat.o(28634);
    }

    public void setMaskID(int i2) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(28635);
        setTag(obj);
        AppMethodBeat.o(28635);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public Object getTagObject() {
        AppMethodBeat.i(28636);
        Object tag = getTag();
        AppMethodBeat.o(28636);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(28637);
        Context context = getContext();
        AppMethodBeat.o(28637);
        return context;
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void im(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setCanPlay(boolean z) {
        this.Dnr.DmM = z;
    }

    public void setOnCompletionListener(b.e eVar) {
        this.Dnr.DmZ = eVar;
    }

    public void setOnSightCompletionAction(b.g gVar) {
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(28638);
        this.Dnr.setThumbBgView(view);
        AppMethodBeat.o(28638);
    }

    public void setIsWhatsNew(boolean z) {
        this.Dnr.DmR = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(28639);
        this.Dnr.setSightInfoView(textView);
        AppMethodBeat.o(28639);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setForceRecordState(boolean z) {
        this.Dnr.DmX = z;
    }

    public void setOnDecodeDurationListener(b.f fVar) {
        AppMethodBeat.i(232058);
        this.Dnr.setOnDecodeDurationListener(fVar);
        AppMethodBeat.o(232058);
    }
}
