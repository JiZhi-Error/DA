package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.sdk.platformtools.Util;

public class DownloadUpdateDescView extends FrameLayout {
    private TextView ljh;
    private TextView qMw;
    private i qMx;

    static /* synthetic */ void d(DownloadUpdateDescView downloadUpdateDescView) {
        AppMethodBeat.i(183820);
        downloadUpdateDescView.cCn();
        AppMethodBeat.o(183820);
    }

    public DownloadUpdateDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(183817);
        super.onFinishInflate();
        this.qMw = (TextView) findViewById(R.id.j0i);
        this.ljh = (TextView) findViewById(R.id.j0h);
        this.ljh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadUpdateDescView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(183815);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/downloader_app/ui/DownloadUpdateDescView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (DownloadUpdateDescView.this.ljh.getText().equals(DownloadUpdateDescView.this.getResources().getString(R.string.c2t))) {
                    DownloadUpdateDescView.this.qMw.setMaxLines(Integer.MAX_VALUE);
                    DownloadUpdateDescView.this.qMw.setText(DownloadUpdateDescView.this.qMx.qLg);
                    DownloadUpdateDescView.this.ljh.setText(R.string.fjh);
                } else {
                    DownloadUpdateDescView.this.qMw.setMaxLines(2);
                    DownloadUpdateDescView.this.ljh.setText(R.string.c2t);
                    DownloadUpdateDescView.d(DownloadUpdateDescView.this);
                }
                com.tencent.mm.plugin.downloader_app.b.a.a(10, 1003, 0, 2, DownloadUpdateDescView.this.qMx.appId, "", "");
                a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DownloadUpdateDescView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183815);
            }
        });
        AppMethodBeat.o(183817);
    }

    public void setData(i iVar) {
        AppMethodBeat.i(183818);
        this.qMx = iVar;
        if (!Util.isNullOrNil(this.qMx.qLg)) {
            setVisibility(0);
            this.qMw.setMaxLines(2);
            this.ljh.setVisibility(8);
            this.qMw.setText(this.qMx.qLg);
            cCn();
            AppMethodBeat.o(183818);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(183818);
    }

    private void cCn() {
        AppMethodBeat.i(183819);
        this.qMw.post(new Runnable() {
            /* class com.tencent.mm.plugin.downloader_app.ui.DownloadUpdateDescView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(183816);
                int lineCount = DownloadUpdateDescView.this.qMw.getLineCount();
                if (lineCount > 2) {
                    AppMethodBeat.o(183816);
                    return;
                }
                Layout layout = DownloadUpdateDescView.this.qMw.getLayout();
                TextPaint paint = DownloadUpdateDescView.this.qMw.getPaint();
                if (layout != null && lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    int lineEnd = layout.getLineEnd(0);
                    String charSequence = DownloadUpdateDescView.this.qMw.getText().toString();
                    String substring = charSequence.substring(lineEnd, lineEnd * 2);
                    int measureText = (int) paint.measureText(substring);
                    int measureText2 = (int) paint.measureText(".");
                    int measureText3 = (int) paint.measureText(DownloadUpdateDescView.this.getResources().getString(R.string.c2t));
                    while (measureText + (measureText2 * 3) + measureText3 > layout.getEllipsizedWidth() && substring.length() > 0) {
                        substring = substring.substring(0, substring.length() - 1);
                        measureText = (int) paint.measureText(substring);
                    }
                    DownloadUpdateDescView.this.qMw.setText(charSequence.substring(0, lineEnd) + substring + "...");
                    DownloadUpdateDescView.this.ljh.setVisibility(0);
                }
                AppMethodBeat.o(183816);
            }
        });
        AppMethodBeat.o(183819);
    }
}
