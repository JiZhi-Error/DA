package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import junit.framework.Assert;

public class FriendPreference extends Preference implements e.a {
    private TextView BfZ;
    private ImageView Bga;
    private ImageView Bgb;
    private a Bgc;
    private String Bgd;
    private long Bge;
    private long Bgf;
    private as contact;
    private int dUW;
    private MMActivity gte;
    private String kcp;
    private boolean rFe;
    private TextView titleTv;

    static /* synthetic */ boolean a(FriendPreference friendPreference, String str, Bitmap bitmap) {
        AppMethodBeat.i(27250);
        boolean q = friendPreference.q(str, bitmap);
        AppMethodBeat.o(27250);
        return q;
    }

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27235);
        this.gte = (MMActivity) context;
        init();
        AppMethodBeat.o(27235);
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27236);
        setLayoutResource(R.layout.b8j);
        setWidgetLayoutResource(R.layout.b_t);
        init();
        AppMethodBeat.o(27236);
    }

    private void init() {
        this.rFe = false;
        this.contact = null;
        this.Bgc = null;
        this.Bgd = "";
        this.Bge = 0;
        this.Bgf = 0;
        this.dUW = 0;
        this.kcp = "";
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27237);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b97, viewGroup2);
        AppMethodBeat.o(27237);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27238);
        this.titleTv = (TextView) view.findViewById(R.id.ipm);
        this.BfZ = (TextView) view.findViewById(R.id.ied);
        this.Bga = (ImageView) view.findViewById(R.id.dvz);
        this.Bgb = (ImageView) view.findViewById(R.id.fh6);
        this.rFe = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(27238);
    }

    private void initView() {
        AppMethodBeat.i(27239);
        if (this.contact == null || !this.rFe) {
            Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
            AppMethodBeat.o(27239);
        } else if (this.Bge != -1 && new p(this.Bge).longValue() > 0) {
            setWidgetLayoutResource(R.layout.b_u);
            eEF();
            AppMethodBeat.o(27239);
        } else if (this.Bgc != null) {
            setWidgetLayoutResource(R.layout.b_h);
            eEG();
            AppMethodBeat.o(27239);
        } else if (this.Bgf > 0) {
            eEE();
            AppMethodBeat.o(27239);
        } else if (!TextUtils.isEmpty(this.kcp)) {
            eEH();
            AppMethodBeat.o(27239);
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.o(27239);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eEE() {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.FriendPreference.eEE():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eEF() {
        /*
        // Method dump skipped, instructions count: 291
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.FriendPreference.eEF():void");
    }

    private void eEG() {
        AppMethodBeat.i(27242);
        if (this.contact == null || !this.rFe) {
            Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
            AppMethodBeat.o(27242);
        } else if (this.Bgc == null) {
            AppMethodBeat.o(27242);
        } else {
            this.dUW = 1;
            this.titleTv.setText(this.mContext.getString(R.string.bbh));
            final String str = Util.nullAsNil(this.Bgc.bnK()) + " " + Util.nullAsNil(this.Bgc.bnP()).replace(" ", "");
            this.BfZ.setText(str);
            Bitmap a2 = l.a(this.Bgc.bnJ(), this.mContext);
            if (a2 == null) {
                this.Bga.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.raw.default_mobile_avatar));
            } else {
                this.Bga.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(Bitmap.createScaledBitmap(a2, 78, 78, false), true, 0.0f));
            }
            bg.aVF();
            if (c.aSN().bjG(this.Bgc.getUsername())) {
                this.Bgb.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.FriendPreference.AnonymousClass1 */

                    public final void onClick(View view) {
                        final String[] stringArray;
                        AppMethodBeat.i(27233);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/FriendPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (FriendPreference.this.Bgc == null || Util.isNullOrNil(FriendPreference.this.Bgc.iKR)) {
                            stringArray = FriendPreference.this.gte.getResources().getStringArray(R.array.ab);
                        } else {
                            stringArray = FriendPreference.this.gte.getResources().getStringArray(R.array.aa);
                        }
                        h.a(FriendPreference.this.gte, (String) null, stringArray, (String) null, new h.d() {
                            /* class com.tencent.mm.plugin.profile.ui.FriendPreference.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.h.d
                            public final void oj(int i2) {
                                AppMethodBeat.i(27232);
                                switch (i2) {
                                    case 0:
                                        if (str == null || str.length() == 0) {
                                            AppMethodBeat.o(27232);
                                            return;
                                        }
                                        int lastIndexOf = str.lastIndexOf(32) + 1;
                                        if (lastIndexOf > 0) {
                                            FriendPreference.a(FriendPreference.this, str.substring(lastIndexOf));
                                            AppMethodBeat.o(27232);
                                            return;
                                        }
                                        break;
                                    case 1:
                                        if (str == null || str.length() == 0) {
                                            AppMethodBeat.o(27232);
                                            return;
                                        }
                                        String substring = str.substring(0, str.lastIndexOf(32));
                                        if (substring == null || substring.length() == 0) {
                                            AppMethodBeat.o(27232);
                                            return;
                                        }
                                        ab.c(FriendPreference.this.contact, substring.trim());
                                        AppMethodBeat.o(27232);
                                        return;
                                    case 2:
                                        if (stringArray == null || stringArray.length <= 2 || FriendPreference.this.Bgc == null || FriendPreference.this.contact == null) {
                                            AppMethodBeat.o(27232);
                                            return;
                                        } else if (FriendPreference.this.Bgc != null && !Util.isNullOrNil(FriendPreference.this.Bgc.iKR)) {
                                            FriendPreference.a(FriendPreference.this, FriendPreference.this.contact.field_username, FriendPreference.this.Bgc.iKR);
                                            AppMethodBeat.o(27232);
                                            return;
                                        }
                                        break;
                                    case 3:
                                        Intent intent = new Intent();
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("fromScene", 2);
                                        intent.putExtra("reportArgs", bundle);
                                        com.tencent.mm.plugin.profile.b.jRt.j(intent, FriendPreference.this.gte);
                                        break;
                                }
                                AppMethodBeat.o(27232);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/FriendPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(27233);
                    }
                });
                AppMethodBeat.o(27242);
                return;
            }
            this.Bgb.setVisibility(4);
            AppMethodBeat.o(27242);
        }
    }

    private void eEH() {
        AppMethodBeat.i(27243);
        if (this.contact == null || !this.rFe) {
            Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
            AppMethodBeat.o(27243);
            return;
        }
        this.dUW = 3;
        this.titleTv.setText(this.mContext.getString(R.string.fxs));
        this.BfZ.setText(Util.nullAsNil(this.kcp));
        this.Bga.setVisibility(8);
        AppMethodBeat.o(27243);
    }

    private boolean q(String str, Bitmap bitmap) {
        AppMethodBeat.i(27244);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            boolean a2 = l.a(str, this.mContext, byteArrayOutputStream.toByteArray());
            AppMethodBeat.o(27244);
            return a2;
        }
        AppMethodBeat.o(27244);
        return false;
    }

    public final boolean cCs() {
        AppMethodBeat.i(27245);
        com.tencent.mm.aj.p.aYn().e(this);
        AppMethodBeat.o(27245);
        return true;
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(27246);
        long Ma = com.tencent.mm.aj.c.Ma(str);
        if (Ma > 0 && this.Bge == Ma && com.tencent.mm.aj.c.a(str, false, -1, null) != null) {
            initView();
        }
        if (com.tencent.mm.aj.c.LZ(str) == this.Bgf && com.tencent.mm.aj.c.a(str, false, -1, null) != null) {
            initView();
        }
        AppMethodBeat.o(27246);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final /* synthetic */ CharSequence getSummary() {
        AppMethodBeat.i(27247);
        String charSequence = this.BfZ.getText().toString();
        AppMethodBeat.o(27247);
        return charSequence;
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str) {
        AppMethodBeat.i(27248);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        MMActivity mMActivity = friendPreference.gte;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/FriendPreference", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mMActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/FriendPreference", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(27248);
    }

    static /* synthetic */ void a(FriendPreference friendPreference, final String str, final String str2) {
        AppMethodBeat.i(27249);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.string.bez), 0).show();
            AppMethodBeat.o(27249);
            return;
        }
        com.tencent.mm.aj.p.aYn();
        Bitmap Mo = e.Mo(str);
        if (Mo == null) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.string.bf0), 0).show();
            final f fVar = new f();
            fVar.a(str, new f.c() {
                /* class com.tencent.mm.plugin.profile.ui.FriendPreference.AnonymousClass2 */

                @Override // com.tencent.mm.aj.f.c
                public final int dp(int i2, int i3) {
                    AppMethodBeat.i(27234);
                    fVar.sQ();
                    Log.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        com.tencent.mm.aj.p.aYn();
                        if (FriendPreference.a(FriendPreference.this, str2, e.Mo(str))) {
                            Toast.makeText(FriendPreference.this.mContext, FriendPreference.this.mContext.getString(R.string.bf1), 0).show();
                            AppMethodBeat.o(27234);
                            return 0;
                        }
                    }
                    Toast.makeText(FriendPreference.this.mContext, FriendPreference.this.mContext.getString(R.string.bez), 0).show();
                    AppMethodBeat.o(27234);
                    return 0;
                }
            });
            AppMethodBeat.o(27249);
        } else if (friendPreference.q(str2, Mo)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.string.bf1), 0).show();
            AppMethodBeat.o(27249);
        } else {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.string.bez), 0).show();
            AppMethodBeat.o(27249);
        }
    }
}
