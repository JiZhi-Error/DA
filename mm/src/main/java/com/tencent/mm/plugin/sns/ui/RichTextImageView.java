package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class RichTextImageView extends LinearLayout {
    private TextView EpI;
    private TextView EvL;
    private boolean EvM = false;
    private String EvN;
    private Activity dKq;
    private TextView titleTv;
    private ImageView zky;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(98234);
        this.dKq = (Activity) context;
        View inflate = inflate(this.dKq, R.layout.bx0, this);
        this.EpI = (TextView) inflate.findViewById(R.id.h7r);
        this.titleTv = (TextView) inflate.findViewById(R.id.ir7);
        this.EvL = (TextView) inflate.findViewById(R.id.abn);
        this.zky = (ImageView) inflate.findViewById(R.id.dw4);
        AppMethodBeat.o(98234);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(98235);
        this.titleTv.setText(str);
        AppMethodBeat.o(98235);
    }

    public void setText(String str) {
        AppMethodBeat.i(98236);
        this.EvM = true;
        if (str == null) {
            str = "";
        }
        this.EvN = str;
        this.EpI.setText(this.EvN);
        requestLayout();
        AppMethodBeat.o(98236);
    }

    public void setImage(int i2) {
        AppMethodBeat.i(98237);
        this.zky.setImageResource(i2);
        AppMethodBeat.o(98237);
    }

    public void setImage(Bitmap bitmap) {
        AppMethodBeat.i(98238);
        this.zky.setImageBitmap(bitmap);
        AppMethodBeat.o(98238);
    }

    public ImageView getImageView() {
        return this.zky;
    }

    public TextView getTitle() {
        return this.titleTv;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(98239);
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.EvM) {
            AppMethodBeat.o(98239);
        } else if (this.EvN == null) {
            AppMethodBeat.o(98239);
        } else {
            Log.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.EpI.getHeight() + " LineHeight:" + this.EpI.getLineHeight());
            int height = this.EpI.getHeight() / this.EpI.getLineHeight();
            int lineCount = this.EpI.getLineCount();
            Rect rect = new Rect();
            int i6 = 0;
            int i7 = 0;
            while (i6 < height) {
                try {
                    this.EpI.getLineBounds(i6, rect);
                    i7 += rect.height();
                    if (i7 > this.EpI.getHeight()) {
                        break;
                    }
                    i6++;
                } catch (IndexOutOfBoundsException e2) {
                }
            }
            if (lineCount >= i6 && this.EvM) {
                if (i6 <= 0) {
                    i6 = 1;
                }
                final int lineVisibleEnd = this.EpI.getLayout().getLineVisibleEnd(i6 - 1);
                StringBuilder append = new StringBuilder("bottomH:").append(this.EvL.getHeight()).append("length");
                String str = this.EvN;
                Log.e(APMidasPayAPI.ENV_TEST, append.append(str.substring(lineVisibleEnd, str.length()).length()).toString());
                Log.e(APMidasPayAPI.ENV_TEST, "bottomH:" + this.EvL.getHeight());
                if (this.EvL.getText().length() > 0) {
                    this.EvL.setVisibility(0);
                    this.EvM = false;
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.RichTextImageView.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(98233);
                            RichTextImageView.this.EpI.setText(RichTextImageView.this.EvN.substring(0, lineVisibleEnd));
                            RichTextImageView.this.EvL.setText(RichTextImageView.this.EvN.substring(lineVisibleEnd, RichTextImageView.this.EvN.length()));
                            RichTextImageView.this.EvL.invalidate();
                            RichTextImageView.this.EvM = false;
                            Log.e(APMidasPayAPI.ENV_TEST, "bottomH:" + RichTextImageView.this.EvL.getHeight());
                            AppMethodBeat.o(98233);
                        }
                    });
                }
                Log.e(APMidasPayAPI.ENV_TEST, "bottom:" + i5 + "   mesH:" + this.EvL.getMeasuredHeight());
            }
            AppMethodBeat.o(98239);
        }
    }
}
