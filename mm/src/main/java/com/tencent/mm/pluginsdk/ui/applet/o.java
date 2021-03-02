package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.f;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class o implements y {
    private static int[] Kfa = {R.id.iqb, R.id.iqc, R.id.iqd, R.id.iqe, R.id.iqf, R.id.iqg, R.id.iqh, R.id.iqi, R.id.iqj};

    static /* synthetic */ void a(Context context, d dVar, String str, y.a aVar, y.a aVar2) {
        AppMethodBeat.i(31412);
        a(context, dVar, str, (String) null, aVar, aVar2);
        AppMethodBeat.o(31412);
    }

    static /* synthetic */ void b(Context context, d.a aVar, Object obj) {
        AppMethodBeat.i(31408);
        a(context, aVar, obj);
        AppMethodBeat.o(31408);
    }

    public static class a {
        final d.a Kfg;
        public String Kfh = null;
        public d kdo;
        Context mContext;
        public DialogInterface.OnDismissListener opQ;

        public a(Context context) {
            AppMethodBeat.i(31360);
            this.mContext = context;
            this.Kfg = new d.a(this.mContext);
            this.Kfg.Dk(false);
            this.Kfg.Dl(false);
            this.Kfg.a(new d.a.AbstractC2137d() {
                /* class com.tencent.mm.pluginsdk.ui.applet.o.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.a.d.a.AbstractC2137d
                public final CharSequence a(CharSequence charSequence, float f2) {
                    AppMethodBeat.i(31359);
                    SpannableString a2 = ((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(a.this.mContext, charSequence, f2);
                    AppMethodBeat.o(31359);
                    return a2;
                }
            });
            AppMethodBeat.o(31360);
        }

        public final a ea(Object obj) {
            AppMethodBeat.i(31361);
            o.b(this.mContext, this.Kfg, obj);
            this.Kfg.Di(true);
            AppMethodBeat.o(31361);
            return this;
        }

        public final a beP(String str) {
            AppMethodBeat.i(31362);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, (int) (20.0f * com.tencent.mm.cb.a.ez(this.mContext)));
            if (!Util.isNullOrNil(str)) {
                this.Kfg.az(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, str.toString(), (float) fromDPToPix));
            }
            AppMethodBeat.o(31362);
            return this;
        }

        public final a gpx() {
            AppMethodBeat.i(31363);
            this.Kfg.aoT(2);
            AppMethodBeat.o(31363);
            return this;
        }

        public final a beQ(String str) {
            AppMethodBeat.i(31364);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, (int) (14.0f * com.tencent.mm.cb.a.ez(this.mContext)));
            if (!Util.isNullOrNil(str)) {
                this.Kfg.aB(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, str.toString(), (float) fromDPToPix));
            }
            AppMethodBeat.o(31364);
            return this;
        }

        public final a beR(String str) {
            AppMethodBeat.i(31365);
            this.Kfg.boq(str);
            AppMethodBeat.o(31365);
            return this;
        }

        public final a gpy() {
            this.Kfg.QNF.NIu = 8;
            return this;
        }

        public final a l(Bitmap bitmap, int i2) {
            AppMethodBeat.i(31366);
            this.Kfg.b(bitmap, true, i2);
            this.Kfg.Di(false);
            o.b(this.Kfg, bitmap);
            AppMethodBeat.o(31366);
            return this;
        }

        public final a beS(String str) {
            AppMethodBeat.i(31367);
            o.a(this.mContext, this.Kfg, str);
            this.Kfg.Di(false);
            AppMethodBeat.o(31367);
            return this;
        }

        public final a a(EmojiInfo emojiInfo, String str) {
            AppMethodBeat.i(232195);
            o.a(this.mContext, this.Kfg, emojiInfo, str);
            this.Kfg.Di(false);
            AppMethodBeat.o(232195);
            return this;
        }

        public final a a(d.a.b bVar) {
            AppMethodBeat.i(31368);
            this.Kfg.c(bVar);
            AppMethodBeat.o(31368);
            return this;
        }

        public final a gl(View view) {
            AppMethodBeat.i(31369);
            this.Kfg.hs(view);
            AppMethodBeat.o(31369);
            return this;
        }

        public final a p(Boolean bool) {
            AppMethodBeat.i(31370);
            this.Kfg.Dj(bool.booleanValue());
            if (bool.booleanValue()) {
                this.Kfg.bos(this.mContext.getString(R.string.b97));
            }
            AppMethodBeat.o(31370);
            return this;
        }

        public final a gpz() {
            AppMethodBeat.i(31371);
            this.Kfg.Di(false);
            AppMethodBeat.o(31371);
            return this;
        }

        public final a aii(int i2) {
            AppMethodBeat.i(31372);
            this.Kfh = this.mContext.getResources().getString(i2);
            AppMethodBeat.o(31372);
            return this;
        }

        public final a a(y.a aVar) {
            AppMethodBeat.i(31373);
            this.kdo = this.Kfg.hbn();
            if (this.opQ != null) {
                this.kdo.setOnDismissListener(this.opQ);
            }
            o.a(this.mContext, this.kdo, this.Kfh, aVar, aVar);
            AppMethodBeat.o(31373);
            return this;
        }
    }

    private static void a(Context context, d.a aVar, Object obj) {
        List list;
        AppMethodBeat.i(31374);
        if (obj != null) {
            if (obj instanceof String) {
                list = Util.stringsToList(((String) obj).split(","));
            } else if (obj instanceof List) {
                list = (List) obj;
            } else {
                list = null;
            }
            if (Util.isNullOrNil(list)) {
                AppMethodBeat.o(31374);
                return;
            } else if (list.size() == 1) {
                final String str = (String) list.get(0);
                aVar.az(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(context, context.getString(R.string.g5h).toString(), (float) com.tencent.mm.cb.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.cb.a.ez(context))))).aoR(3);
                String displayName = ((b) g.af(b.class)).getDisplayName(str);
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.cb.a.ez(context)));
                if (ab.Eq(str)) {
                    SpannableString a2 = ((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(context, (displayName + context.getString(R.string.ghu, Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b) g.af(com.tencent.mm.plugin.chatroom.a.b.class)).Ie(str)))).toString(), (float) fromDPToPix);
                    final View inflate = aa.jQ(context).inflate(R.layout.zr, (ViewGroup) null);
                    GridView gridView = (GridView) inflate.findViewById(R.id.arc);
                    final ArrayList arrayList = new ArrayList();
                    final List<String> Ic = ((com.tencent.mm.plugin.chatroom.a.b) g.af(com.tencent.mm.plugin.chatroom.a.b.class)).Ic(str);
                    aVar.a(str, a2, Boolean.TRUE, new d.a.c() {
                        /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.c
                        public final void gpw() {
                            AppMethodBeat.i(31342);
                            Util.hideVKB(inflate);
                            if (arrayList.size() == 0 && !Util.isNullOrNil(str)) {
                                o.a(arrayList, Ic);
                            }
                            AppMethodBeat.o(31342);
                        }
                    }, new d.a.AbstractC2136a() {
                        /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass6 */

                        @Override // com.tencent.mm.ui.widget.a.d.a.AbstractC2136a
                        public final void C(ImageView imageView, String str) {
                            AppMethodBeat.i(31348);
                            com.tencent.mm.ui.g.a.a.c(imageView, str);
                            AppMethodBeat.o(31348);
                        }
                    });
                    gridView.setAdapter((ListAdapter) new t(context, Ic, arrayList));
                    gridView.setSelector(new ColorDrawable(context.getResources().getColor(R.color.ac_)));
                    if (Ic != null) {
                        if (Ic.size() > 16) {
                            gridView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.aG(context, R.dimen.bl)));
                            gridView.setPadding(com.tencent.mm.cb.a.aG(context, R.dimen.bh), 0, com.tencent.mm.cb.a.aG(context, R.dimen.bh), 0);
                        } else {
                            gridView.setPadding(0, 0, 0, com.tencent.mm.cb.a.aG(context, R.dimen.be));
                        }
                    }
                    aVar.QNF.NIo = inflate;
                    AppMethodBeat.o(31374);
                    return;
                }
                aVar.a(str, ((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(context, displayName.toString(), (float) fromDPToPix), Boolean.FALSE, null, new d.a.AbstractC2136a() {
                    /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass9 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.AbstractC2136a
                    public final void C(ImageView imageView, String str) {
                        AppMethodBeat.i(31352);
                        com.tencent.mm.ui.g.a.a.c(imageView, str);
                        AppMethodBeat.o(31352);
                    }
                });
                AppMethodBeat.o(31374);
                return;
            } else {
                aVar.ht(d(context, list));
                aVar.bon(context.getString(R.string.f50)).aoR(3);
            }
        }
        AppMethodBeat.o(31374);
    }

    private static View d(Context context, List<String> list) {
        AppMethodBeat.i(31375);
        View inflate = View.inflate(context, R.layout.w7, null);
        if (list != null) {
            int i2 = 0;
            for (String str : list) {
                if (i2 <= 8 && inflate != null) {
                    ImageView imageView = (ImageView) inflate.findViewById(Kfa[i2]);
                    if (str != null) {
                        imageView.setVisibility(0);
                        com.tencent.mm.ui.g.a.a.c(imageView, str);
                        i2++;
                    }
                }
                i2 = i2;
            }
        }
        AppMethodBeat.o(31375);
        return inflate;
    }

    private static void a(Context context, final d dVar, String str, String str2, final y.a aVar, final y.a aVar2) {
        String str3 = null;
        AppMethodBeat.i(31376);
        if (Util.isNullOrNil(str) || str.length() == 0) {
            str = context.getResources().getString(R.string.b9_);
        }
        if (Util.isNullOrNil((String) null) || str3.length() == 0) {
            str2 = context.getResources().getString(R.string.sz);
        }
        dVar.a(str, true, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(31353);
                dVar.dismiss();
                if (aVar != null) {
                    aVar.a(true, dVar.hbk(), dVar.hbl());
                }
                AppMethodBeat.o(31353);
            }
        });
        dVar.b(str2, true, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(31354);
                dVar.dismiss();
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
                AppMethodBeat.o(31354);
            }
        });
        AppMethodBeat.o(31376);
    }

    public static d a(t tVar, String str, String str2, String str3, boolean z, String str4, y.a aVar) {
        AppMethodBeat.i(31377);
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(31377);
            return null;
        }
        View inflate = View.inflate(tVar.OGe, R.layout.w0, null);
        d.a aVar2 = new d.a(tVar.OGe);
        aVar2.Dk(false);
        aVar2.Dl(false);
        a(aVar2, tVar.OGe, str);
        x(inflate, z);
        a(tVar, aVar2, aVar, inflate, str4);
        TextView textView = (TextView) inflate.findViewById(R.id.b_g);
        textView.setText(l.b(tVar.OGe, str3, textView.getTextSize()));
        inflate.findViewById(R.id.b_c).setVisibility(8);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(tVar.OGe, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.id.b_i);
        if (cdnImageView != null) {
            cdnImageView.aM(str2, fromDPToPix, fromDPToPix);
        }
        aVar2.hs(inflate);
        d hbn = aVar2.hbn();
        hbn.show();
        AppMethodBeat.o(31377);
        return hbn;
    }

    public static d a(t tVar, String str, String str2, boolean z, String str3, y.a aVar, String str4) {
        AppMethodBeat.i(31379);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(31379);
            return null;
        }
        d.a aVar2 = new d.a(tVar.OGe);
        String string = tVar.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(tVar.OGe, aVar2, Util.stringsToList(string.split(",")));
        }
        aVar2.Di(true);
        aVar2.aB(str4 + str).Dk(false).Dl(false);
        if (z) {
            aVar2.Dj(true);
        }
        d hbn = aVar2.hbn();
        a(tVar.OGe, hbn, str3, (String) null, aVar, aVar);
        hbn.show();
        AppMethodBeat.o(31379);
        return hbn;
    }

    public static d b(t tVar, String str, String str2, String str3, String str4, String str5, y.a aVar) {
        AppMethodBeat.i(31380);
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(31380);
            return null;
        }
        View inflate = View.inflate(tVar.OGe, R.layout.w0, null);
        d.a aVar2 = new d.a(tVar.OGe);
        aVar2.Dk(false);
        aVar2.Dl(false);
        a(aVar2, tVar.OGe, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(R.id.b_h);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(tVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.id.b_g);
        textView.setText(l.b(tVar.OGe, str3, textView.getTextSize()));
        inflate.findViewById(R.id.b_c).setVisibility(8);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(tVar.OGe, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.id.b_i);
        if (cdnImageView != null) {
            cdnImageView.aM(str2, fromDPToPix, fromDPToPix);
        }
        aVar2.hs(inflate);
        d hbn = aVar2.hbn();
        hbn.show();
        AppMethodBeat.o(31380);
        return hbn;
    }

    public static d a(t tVar, String str, String str2, y.a aVar) {
        AppMethodBeat.i(31381);
        d a2 = a(tVar, str, str2, false, "", aVar);
        AppMethodBeat.o(31381);
        return a2;
    }

    public static d a(t tVar, String str, boolean z, y.a aVar) {
        AppMethodBeat.i(31382);
        d a2 = a(tVar, str, z, "", aVar);
        AppMethodBeat.o(31382);
        return a2;
    }

    public static d a(t tVar, String str, boolean z, String str2, y.a aVar) {
        AppMethodBeat.i(31383);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            AppMethodBeat.o(31383);
            return null;
        }
        d.a aVar2 = new d.a(tVar.OGe);
        String string = tVar.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(tVar.OGe, aVar2, Util.stringsToList(string.split(",")));
        }
        aVar2.Di(true);
        aVar2.aB(str).Dk(false).Dl(false);
        if (z) {
            aVar2.Dj(true);
        }
        d hbn = aVar2.hbn();
        a(tVar.OGe, hbn, str2, (String) null, aVar, aVar);
        hbn.show();
        AppMethodBeat.o(31383);
        return hbn;
    }

    public static d b(t tVar, String str, boolean z, y.a aVar) {
        AppMethodBeat.i(31384);
        d b2 = b(tVar, str, z, "", aVar);
        AppMethodBeat.o(31384);
        return b2;
    }

    public static d b(t tVar, String str, boolean z, String str2, y.a aVar) {
        AppMethodBeat.i(31385);
        if (str == null || !s.YS(str)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            AppMethodBeat.o(31385);
            return null;
        }
        d.a aVar2 = new d.a(tVar.OGe);
        String string = tVar.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(tVar.OGe, aVar2, Util.stringsToList(string.split(",")));
        }
        aVar2.Di(true);
        aVar2.Dk(false).Dl(false);
        if (z) {
            aVar2.Dj(true);
        }
        if (!Util.isNullOrNil(str)) {
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(str);
            int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
            if (bitmapNative != null) {
                if (exifOrientation != 0) {
                    bitmapNative = BitmapUtil.rotate(bitmapNative, (float) exifOrientation);
                }
                aVar2.b(bitmapNative, true, 3);
                a(aVar2, bitmapNative);
                aVar2.Di(false);
            }
        }
        d hbn = aVar2.hbn();
        a(tVar.OGe, hbn, str2, (String) null, aVar, aVar);
        hbn.show();
        AppMethodBeat.o(31385);
        return hbn;
    }

    public static d a(t tVar, byte[] bArr, boolean z, y.a aVar) {
        AppMethodBeat.i(31386);
        d a2 = a(tVar, bArr, z, "", aVar);
        AppMethodBeat.o(31386);
        return a2;
    }

    public static d a(t tVar, byte[] bArr, boolean z, String str, y.a aVar) {
        AppMethodBeat.i(31387);
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            AppMethodBeat.o(31387);
            return null;
        }
        d.a aVar2 = new d.a(tVar.OGe);
        String string = tVar.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(tVar.OGe, aVar2, Util.stringsToList(string.split(",")));
        }
        aVar2.Di(true);
        aVar2.Dk(false).Dl(false);
        if (z) {
            aVar2.Dj(true);
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Exif exif = new Exif();
            exif.parseFrom(bArr);
            int orientationInDegree = exif.getOrientationInDegree();
            if (decodeByteArray != null) {
                if (orientationInDegree != 0) {
                    decodeByteArray = BitmapUtil.rotate(decodeByteArray, (float) orientationInDegree);
                }
                aVar2.b(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.Di(false);
            }
        }
        d hbn = aVar2.hbn();
        a(tVar.OGe, hbn, str, (String) null, aVar, aVar);
        hbn.show();
        AppMethodBeat.o(31387);
        return hbn;
    }

    public static d a(t tVar, int i2, String str, boolean z, y.a aVar) {
        AppMethodBeat.i(31388);
        d a2 = a(tVar, i2, str, z, "", aVar);
        AppMethodBeat.o(31388);
        return a2;
    }

    public static d a(t tVar, int i2, String str, boolean z, String str2, y.a aVar) {
        String string;
        AppMethodBeat.i(31389);
        d.a aVar2 = new d.a(tVar.OGe);
        String string2 = tVar.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string2 != null) {
            a(tVar.OGe, aVar2, Util.stringsToList(string2.split(",")));
        }
        aVar2.Di(true);
        if (i2 == R.raw.app_attach_file_icon_file) {
            string = tVar.OGe.getResources().getString(R.string.ve);
        } else if (i2 == R.raw.app_attach_file_icon_music) {
            string = tVar.OGe.getResources().getString(R.string.wv);
        } else if (i2 == R.raw.app_attach_file_icon_video) {
            string = tVar.OGe.getResources().getString(R.string.zv);
        } else {
            string = tVar.OGe.getResources().getString(R.string.hb);
        }
        aVar2.aB(string + str).Dk(false).Dl(false);
        if (z) {
            aVar2.Dj(true);
        }
        d hbn = aVar2.hbn();
        a(tVar.OGe, hbn, str2, (String) null, aVar, aVar);
        hbn.show();
        AppMethodBeat.o(31389);
        return hbn;
    }

    public static d a(t tVar, String str, boolean z, int i2, y.a aVar) {
        AppMethodBeat.i(31390);
        d a2 = a(tVar, str, z, i2, "", aVar);
        AppMethodBeat.o(31390);
        return a2;
    }

    public static d a(t tVar, String str, boolean z, int i2, String str2, y.a aVar) {
        ArrayList<String> arrayList;
        String string;
        AppMethodBeat.i(31391);
        d.a aVar2 = new d.a(tVar.OGe);
        String string2 = tVar.OGe.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string2 != null) {
            arrayList = Util.stringsToList(string2.split(","));
        } else {
            arrayList = null;
        }
        a(tVar.OGe, aVar2, arrayList);
        aVar2.Di(true);
        switch (i2) {
            case 1:
                string = tVar.OGe.getResources().getString(R.string.zv);
                break;
            case 2:
                string = tVar.OGe.getResources().getString(R.string.wv);
                break;
            default:
                string = tVar.OGe.getResources().getString(R.string.hb);
                break;
        }
        aVar2.aB(new StringBuffer(string).append(str).toString()).Dk(false).Dl(false);
        if (z) {
            aVar2.Dj(true);
        }
        d hbn = aVar2.hbn();
        a(tVar.OGe, hbn, str2, (String) null, aVar, aVar);
        hbn.show();
        AppMethodBeat.o(31391);
        return hbn;
    }

    public static d a(t tVar, String str, Bitmap bitmap, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(232196);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
            AppMethodBeat.o(232196);
            return null;
        }
        View aC = aC(tVar.OGe, R.layout.w2);
        d.a aVar2 = new d.a(tVar.OGe);
        aVar2.Dk(false);
        aVar2.Dl(false);
        x(aC, false);
        a(tVar, aVar2, aVar, aC, tVar.OGe.getResources().getString(R.string.b9y));
        TextView textView = (TextView) aC.findViewById(R.id.b_j);
        textView.setText(l.b(tVar.OGe, str, textView.getTextSize()));
        textView.getPaint().setFakeBoldText(true);
        TextView textView2 = (TextView) aC.findViewById(R.id.b_g);
        textView2.setText(l.b(tVar.OGe, str2, textView2.getTextSize()));
        ImageView imageView = (ImageView) aC.findViewById(R.id.b_i);
        if (imageView != null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                imageView.setImageBitmap(bitmap);
                a(aVar2, bitmap);
            } else if (!Util.isNullOrNil(str3)) {
                com.tencent.mm.av.a.a bcV = q.bcV();
                c.a aVar3 = new c.a();
                aVar3.jbq = R.drawable.bar;
                aVar3.jbe = true;
                aVar3.iaT = true;
                bcV.a(str3, imageView, aVar3.bdv());
            } else {
                imageView.setImageResource(R.drawable.bar);
            }
        }
        aVar2.hs(aC);
        d hbn = aVar2.hbn();
        hbn.show();
        AppMethodBeat.o(232196);
        return hbn;
    }

    public static void a(t tVar, String str, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(31397);
        a p = new a(tVar.OGe).ea(str).beQ(str2).p(Boolean.FALSE);
        p.Kfh = str3;
        p.a(aVar).kdo.show();
        AppMethodBeat.o(31397);
    }

    public static d a(t tVar, String str, View view, String str2, final y.b bVar) {
        AppMethodBeat.i(31398);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(31398);
            return null;
        }
        d.a aVar = new d.a(tVar.OGe);
        aVar.Dk(false);
        aVar.Dl(false);
        a(aVar, tVar.OGe, str);
        if (Util.isNullOrNil(str2) || str2.length() == 0) {
            str2 = tVar.OGe.getResources().getString(R.string.b9_);
        }
        aVar.bou(str2).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(31343);
                if (bVar != null) {
                    bVar.qB(true);
                }
                AppMethodBeat.o(31343);
            }
        });
        aVar.aoW(R.string.sz).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(31344);
                if (bVar != null) {
                    bVar.qB(false);
                }
                AppMethodBeat.o(31344);
            }
        });
        aVar.hs(view);
        d hbn = aVar.hbn();
        hbn.ajL(tVar.OGe.getResources().getColor(R.color.g7));
        hbn.show();
        AppMethodBeat.o(31398);
        return hbn;
    }

    private static View aC(Context context, int i2) {
        AppMethodBeat.i(31399);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i2, (ViewGroup) null);
        AppMethodBeat.o(31399);
        return inflate;
    }

    private static p gi(View view) {
        AppMethodBeat.i(31400);
        p pVar = new p(view, -1, -1);
        AppMethodBeat.o(31400);
        return pVar;
    }

    private static void a(t tVar, d.a aVar, final y.a aVar2, final View view, String str) {
        AppMethodBeat.i(31401);
        if (Util.isNullOrNil(str) || str.length() == 0) {
            str = tVar.OGe.getResources().getString(R.string.b9_);
        }
        aVar.bou(str).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(232194);
                if (aVar2 != null) {
                    aVar2.a(true, o.gj(view), o.gk(view));
                }
                AppMethodBeat.o(232194);
            }
        });
        aVar.aoW(R.string.sz).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass15 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(31358);
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
                AppMethodBeat.o(31358);
            }
        });
        AppMethodBeat.o(31401);
    }

    private static void a(d.a aVar, Context context, String str) {
        AppMethodBeat.i(31402);
        aVar.bon(str);
        aVar.aoP(context.getResources().getColor(R.color.a2x));
        aVar.aoQ(2);
        AppMethodBeat.o(31402);
    }

    private static void a(final View view, final y.a aVar, final p pVar) {
        AppMethodBeat.i(31403);
        ((Button) view.findViewById(R.id.b_6)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(232192);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aVar != null) {
                    aVar.a(true, o.gj(view), o.gk(view));
                }
                pVar.dismiss();
                pVar.setFocusable(false);
                pVar.setTouchable(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232192);
            }
        });
        Button button = (Button) view.findViewById(R.id.b_7);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(31346);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (aVar != null) {
                        aVar.a(false, null, 0);
                    }
                    pVar.dismiss();
                    pVar.setFocusable(false);
                    pVar.setTouchable(false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31346);
                }
            });
        }
        AppMethodBeat.o(31403);
    }

    private static void x(View view, boolean z) {
        EditText editText;
        AppMethodBeat.i(31404);
        if (!(view == null || (editText = (EditText) view.findViewById(R.id.b_h)) == null)) {
            editText.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(31404);
    }

    private static void a(View view, int i2, String str, boolean z, int i3) {
        AppMethodBeat.i(31405);
        TextView textView = (TextView) view.findViewById(i2);
        Assert.assertTrue(textView != null);
        if (!z || !Util.isNullOrNil(str)) {
            textView.setText(str);
            AppMethodBeat.o(31405);
            return;
        }
        textView.setVisibility(i3);
        AppMethodBeat.o(31405);
    }

    private static void a(d.a aVar, final Bitmap bitmap) {
        AppMethodBeat.i(31407);
        aVar.a(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass7 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(232193);
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(232193);
                } else {
                    AppMethodBeat.o(232193);
                }
            }
        });
        AppMethodBeat.o(31407);
    }

    public static d a(t tVar, String str, String str2, boolean z, String str3, y.a aVar) {
        AppMethodBeat.i(31378);
        d a2 = a(tVar, str, str2, z, str3, aVar, tVar.OGe.getResources().getString(R.string.zp));
        AppMethodBeat.o(31378);
        return a2;
    }

    public static d a(t tVar, Bitmap bitmap, String str, String str2, String str3, y.a aVar) {
        AppMethodBeat.i(31392);
        View aC = aC(tVar.OGe, R.layout.w1);
        d.a aVar2 = new d.a(tVar.OGe);
        aVar2.Dk(false);
        aVar2.Dl(false);
        x(aC, true);
        a(tVar, aVar2, aVar, aC, tVar.OGe.getResources().getString(R.string.b9_));
        TextView textView = (TextView) aC.findViewById(R.id.b_j);
        textView.setText(l.b(tVar.OGe, str, textView.getTextSize()));
        TextView textView2 = (TextView) aC.findViewById(R.id.b_g);
        textView2.setText(l.b(tVar.OGe, str2, textView2.getTextSize()));
        TextView textView3 = (TextView) aC.findViewById(R.id.b_c);
        if (str3 == null || str3.length() == 0) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(str3);
            textView3.setVisibility(0);
        }
        ImageView imageView = (ImageView) aC.findViewById(R.id.b_i);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                Log.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap);
                a(aVar2, bitmap);
            }
        }
        aVar2.hs(aC);
        d hbn = aVar2.hbn();
        hbn.show();
        AppMethodBeat.o(31392);
        return hbn;
    }

    public static p a(t tVar, String str, String str2, String str3, String str4, String str5, final y.a aVar) {
        AppMethodBeat.i(31395);
        final View aC = aC(tVar.OGe, R.layout.w4);
        final p gi = gi(aC);
        a(aC, aVar, gi);
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            AppMethodBeat.o(31395);
            return null;
        }
        a(aC, (int) R.id.b_j, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) aC.findViewById(R.id.b_g);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, tVar.OGe.getResources().getDimension(R.dimen.l) * com.tencent.mm.cb.a.ez(tVar.OGe));
        noMeasuredTextView.setTextColor(com.tencent.mm.cb.a.m(tVar.OGe, R.color.a2x));
        if (!Util.isNullOrNil(str)) {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).b(tVar.OGe, ((b) g.af(b.class)).getDisplayName(str), noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).b(tVar.OGe, str3, noMeasuredTextView.getTextSize()));
        }
        a(aC, (int) R.id.b_d, str4, true, 8);
        Button button = (Button) aC.findViewById(R.id.b_6);
        if (!Util.isNullOrNil(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(31355);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aVar != null) {
                    aVar.a(true, o.gj(aC), o.gk(aC));
                }
                gi.dismiss();
                gi.setFocusable(false);
                gi.setTouchable(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31355);
            }
        });
        if (!Util.isNullOrNil(str)) {
            a.b.c((ImageView) aC.findViewById(R.id.b_i), str);
        }
        a(tVar, gi);
        AppMethodBeat.o(31395);
        return gi;
    }

    public static p a(t tVar, long j2, String str, String str2, String str3, final y.a aVar) {
        String str4;
        String str5;
        String str6;
        AppMethodBeat.i(31396);
        final View aC = aC(tVar.OGe, R.layout.w4);
        final p gi = gi(aC);
        a(aC, aVar, gi);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            AppMethodBeat.o(31396);
            return null;
        }
        a(aC, (int) R.id.b_j, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) aC.findViewById(R.id.b_g);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, tVar.OGe.getResources().getDimension(R.dimen.l) * com.tencent.mm.cb.a.ez(tVar.OGe));
        noMeasuredTextView.setTextColor(com.tencent.mm.cb.a.m(tVar.OGe, R.color.a2x));
        com.tencent.mm.al.a.c bs = ((k) g.af(k.class)).bs(j2);
        if (bs == null || !bs.isGroup()) {
            com.tencent.mm.al.a.k fB = ((com.tencent.mm.api.l) g.af(com.tencent.mm.api.l.class)).fB(bs.field_bizChatServId);
            if (fB != null) {
                str4 = fB.field_userName;
                str5 = fB.field_headImageUrl;
                str6 = fB.field_brandUserName;
            } else {
                Log.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                AppMethodBeat.o(31396);
                return null;
            }
        } else {
            str4 = bs.field_chatName;
            str5 = bs.field_headImageUrl;
            str6 = bs.field_brandUserName;
        }
        if (str4 == null) {
            str4 = str2;
        }
        if (!Util.isNullOrNil(str4)) {
            noMeasuredTextView.setText(l.b(tVar.OGe, str4, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(l.b(tVar.OGe, str2, noMeasuredTextView.getTextSize()));
        }
        a(aC, (int) R.id.b_d, (String) null, true, 8);
        Button button = (Button) aC.findViewById(R.id.b_6);
        if (!Util.isNullOrNil(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(31356);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (aVar != null) {
                    aVar.a(true, o.gj(aC), o.gk(aC));
                }
                gi.dismiss();
                gi.setFocusable(false);
                gi.setTouchable(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31356);
            }
        });
        c.a aVar2 = new c.a();
        aVar2.prefixPath = com.tencent.mm.api.a.fe(str6);
        aVar2.jbf = true;
        aVar2.hZF = true;
        aVar2.jbq = R.raw.default_avatar;
        c bdv = aVar2.bdv();
        if (!Util.isNullOrNil(str5)) {
            q.bcV().a(str5, (ImageView) aC.findViewById(R.id.b_i), bdv);
        }
        a(tVar, gi);
        AppMethodBeat.o(31396);
        return gi;
    }

    private static void a(t tVar, p pVar) {
        AppMethodBeat.i(31406);
        try {
            if (!tVar.OGe.isFinishing()) {
                pVar.setInputMethodMode(1);
                pVar.setSoftInputMode(16);
                pVar.setFocusable(true);
                pVar.setTouchable(true);
                pVar.showAtLocation(tVar.OGe.getWindow().getDecorView(), 17, 0, 0);
            }
            AppMethodBeat.o(31406);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.MMConfirmDialog", e2, "", new Object[0]);
            AppMethodBeat.o(31406);
        }
    }

    static /* synthetic */ void b(d.a aVar, final Bitmap bitmap) {
        AppMethodBeat.i(31409);
        aVar.a(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.o.AnonymousClass8 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(31350);
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(31350);
                    return;
                }
                Log.i("MicroMsg.MMConfirmDialog", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.o(31350);
            }
        });
        AppMethodBeat.o(31409);
    }

    static /* synthetic */ void a(Context context, d.a aVar, String str) {
        AppMethodBeat.i(31410);
        View inflate = aa.jQ(context).inflate(R.layout.b7j, (ViewGroup) null);
        BaseEmojiView baseEmojiView = (BaseEmojiView) inflate.findViewById(R.id.bqv);
        if (baseEmojiView == null) {
            Log.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
            AppMethodBeat.o(31410);
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MMConfirmDialog", "Error , emoji msg path is null !!");
            AppMethodBeat.o(31410);
        } else {
            EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(str);
            if (str.indexOf(47) == -1) {
                com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                f.cES();
                str = emojiMgr.fU("", str);
            }
            if (aml != null) {
                baseEmojiView.setEmojiInfo(aml);
            } else {
                baseEmojiView.setImageFilePath(str);
            }
            aVar.hs(inflate);
            aVar.aoU(1);
            AppMethodBeat.o(31410);
        }
    }

    static /* synthetic */ void a(Context context, d.a aVar, EmojiInfo emojiInfo, String str) {
        AppMethodBeat.i(31411);
        View inflate = aa.jQ(context).inflate(R.layout.b7j, (ViewGroup) null);
        EmojiStatusView emojiStatusView = (EmojiStatusView) inflate.findViewById(R.id.bqv);
        TextView textView = (TextView) inflate.findViewById(R.id.c08);
        if (emojiStatusView == null) {
            Log.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
            AppMethodBeat.o(31411);
        } else if (emojiInfo == null) {
            Log.e("MicroMsg.MMConfirmDialog", "Error , emoji msg path is null !!");
            AppMethodBeat.o(31411);
        } else {
            if (!TextUtils.isEmpty(str)) {
                textView.setVisibility(0);
                textView.setText(String.format(context.getResources().getString(R.string.h2l), str));
            }
            emojiStatusView.setEmojiInfo(emojiInfo);
            aVar.hs(inflate);
            aVar.aoU(1);
            AppMethodBeat.o(31411);
        }
    }

    static /* synthetic */ void a(ArrayList arrayList, List list) {
        AppMethodBeat.i(31413);
        if (!Util.isNullOrNil(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) g.af(b.class)).getDisplayName((String) it.next()));
            }
        }
        AppMethodBeat.o(31413);
    }

    static /* synthetic */ String gj(View view) {
        AppMethodBeat.i(31414);
        EditText editText = (EditText) view.findViewById(R.id.b_h);
        if (editText == null) {
            AppMethodBeat.o(31414);
            return null;
        }
        String obj = editText.getText().toString();
        AppMethodBeat.o(31414);
        return obj;
    }

    static /* synthetic */ int gk(View view) {
        AppMethodBeat.i(31415);
        EditText editText = (EditText) view.findViewById(R.id.b_h);
        if (editText instanceof PasterEditText) {
            int pasterLen = ((PasterEditText) editText).getPasterLen();
            AppMethodBeat.o(31415);
            return pasterLen;
        }
        AppMethodBeat.o(31415);
        return 0;
    }
}
