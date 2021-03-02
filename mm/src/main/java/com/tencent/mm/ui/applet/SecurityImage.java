package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;

public class SecurityImage extends LinearLayout {
    private ProgressBar ONB = null;
    private ImageView ONC = null;
    private Button OND = null;
    private EditText ONE = null;
    private b ONF;
    private d kdo = null;
    private String kds = null;
    private String kdt = null;
    private int kmJ = 0;

    static /* synthetic */ void a(SecurityImage securityImage) {
        AppMethodBeat.i(141602);
        securityImage.Bu(false);
        AppMethodBeat.o(141602);
    }

    public static abstract class b {
        protected SecurityImage ONI;

        public abstract void bnH();

        public final void d(SecurityImage securityImage) {
            this.ONI = securityImage;
        }
    }

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setNetworkModel(b bVar) {
        AppMethodBeat.i(141594);
        if (this.ONF != null) {
            this.ONF.d(null);
        }
        this.ONF = bVar;
        this.ONF.d(this);
        AppMethodBeat.o(141594);
    }

    public final void a(int i2, byte[] bArr, String str, String str2) {
        AppMethodBeat.i(141595);
        this.ONB = (ProgressBar) findViewById(R.id.gyo);
        this.ONC = (ImageView) findViewById(R.id.w8);
        this.OND = (Button) findViewById(R.id.w6);
        this.ONE = (EditText) findViewById(R.id.w7);
        this.OND.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.applet.SecurityImage.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(141591);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/SecurityImage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SecurityImage.a(SecurityImage.this);
                if (SecurityImage.this.ONF != null) {
                    SecurityImage.this.ONF.bnH();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/SecurityImage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(141591);
            }
        });
        b(i2, bArr, str, str2);
        AppMethodBeat.o(141595);
    }

    public final void b(int i2, byte[] bArr, String str, String str2) {
        AppMethodBeat.i(141596);
        Bu(true);
        c(i2, bArr, str, str2);
        AppMethodBeat.o(141596);
    }

    public int getSecCodeType() {
        return this.kmJ;
    }

    public String getSecImgSid() {
        return this.kds;
    }

    public String getSecImgCode() {
        AppMethodBeat.i(141597);
        if (this.ONE == null) {
            AppMethodBeat.o(141597);
            return "";
        }
        String trim = this.ONE.getText().toString().trim();
        AppMethodBeat.o(141597);
        return trim;
    }

    public String getSecImgEncryptKey() {
        return this.kdt;
    }

    public final void dismiss() {
        AppMethodBeat.i(141598);
        if (this.kdo != null) {
            this.kdo.dismiss();
            this.kdo = null;
        }
        AppMethodBeat.o(141598);
    }

    private void Bu(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(141599);
        this.ONC.setAlpha(z ? 255 : 40);
        this.ONC.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.ONB;
        if (z) {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
        AppMethodBeat.o(141599);
    }

    private void c(int i2, byte[] bArr, String str, String str2) {
        AppMethodBeat.i(141600);
        this.kds = str;
        this.kdt = str2;
        this.kmJ = i2;
        Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
        if (decodeByteArray != null) {
            Log.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", str, str2, Integer.valueOf(bArr.length), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(decodeByteArray.getHeight()));
            a(i2, decodeByteArray, str, str2);
            AppMethodBeat.o(141600);
            return;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        Log.e("MicroMsg.SecurityImage", "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d", objArr);
        AppMethodBeat.o(141600);
    }

    private void a(int i2, Bitmap bitmap, String str, String str2) {
        AppMethodBeat.i(141601);
        this.kds = str;
        this.kdt = str2;
        this.kmJ = i2;
        if (bitmap != null) {
            this.ONC.setImageBitmap(bitmap);
            AppMethodBeat.o(141601);
            return;
        }
        Log.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
        AppMethodBeat.o(141601);
    }

    public static class a {
        public static SecurityImage a(Context context, int i2, byte[] bArr, String str, String str2, final DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnDismissListener onDismissListener, b bVar) {
            AppMethodBeat.i(141593);
            final SecurityImage securityImage = (SecurityImage) View.inflate(context, R.layout.bp_, null);
            securityImage.setNetworkModel(bVar);
            securityImage.a(i2, bArr, str, str2);
            d.a aVar = new d.a(context);
            aVar.aoO(R.string.g0o);
            aVar.aoV(R.string.t9).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.applet.SecurityImage.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(141592);
                    onClickListener.onClick(dialogInterface, i2);
                    AppMethodBeat.o(141592);
                }
            });
            aVar.f(onCancelListener);
            aVar.hs(securityImage);
            aVar.Dk(true);
            securityImage.kdo = aVar.hbn();
            securityImage.kdo.setOnDismissListener(onDismissListener);
            securityImage.kdo.show();
            AppMethodBeat.o(141593);
            return securityImage;
        }
    }
}
