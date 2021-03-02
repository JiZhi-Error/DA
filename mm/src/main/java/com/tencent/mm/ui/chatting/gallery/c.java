package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Map;

public final class c extends s<ca> implements View.OnClickListener {
    private static Map<String, Integer> Pxk;
    private static Map<String, Integer> oYD;
    long PlX;
    private final ImageGalleryGridUI Pxi;
    boolean Pxj = false;
    String gAn;
    protected com.tencent.mm.av.a.a.c gzE = null;
    Context mContext;
    private LayoutInflater mInflater;
    private boolean qoo;
    boolean tca;
    public boolean vtY = false;

    public c(Context context, ca caVar, String str) {
        super(context, caVar);
        AppMethodBeat.i(35938);
        this.Pxi = (ImageGalleryGridUI) context;
        this.gAn = str;
        this.tca = g.DQ(this.gAn);
        if (this.tca) {
            this.PlX = caVar.field_bizChatId;
        }
        bg.aVF();
        this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
        this.mInflater = LayoutInflater.from(context);
        c.a aVar = new c.a();
        aVar.jbi = 1;
        aVar.jby = true;
        aVar.hZA = com.tencent.mm.cb.a.jn(context) / 3;
        aVar.hZz = com.tencent.mm.cb.a.jn(context) / 3;
        aVar.jbt = R.color.a3k;
        this.gzE = aVar.bdv();
        AppMethodBeat.o(35938);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(35939);
        if (this.tca) {
            bg.aVF();
            setCursor(com.tencent.mm.model.c.aSR().bY(this.gAn, this.PlX));
            AppMethodBeat.o(35939);
            return;
        }
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aSQ().aEC(this.gAn));
        AppMethodBeat.o(35939);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(35940);
        if (this.tca) {
            bg.aVF();
            setCursor(com.tencent.mm.model.c.aSR().bY(this.gAn, this.PlX));
            AppMethodBeat.o(35940);
            return;
        }
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aSQ().aEC(this.gAn));
        AppMethodBeat.o(35940);
    }

    @Override // com.tencent.mm.ui.s
    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(35941);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.ava, viewGroup, false);
            aVar = new a();
            aVar.tkI = (ImageView) view.findViewById(R.id.dl0);
            aVar.tkJ = view.findViewById(R.id.j6s);
            aVar.Pxo = (TextView) view.findViewById(R.id.cgd);
            aVar.Pxo.setVisibility(8);
            aVar.Pxn = (ImageView) view.findViewById(R.id.cg7);
            aVar.qog = (TextView) view.findViewById(R.id.j6p);
            aVar.tkJ.setVisibility(8);
            aVar.tkL = view.findViewById(R.id.hry);
            aVar.tkL.setVisibility(8);
            aVar.Pxp = view.findViewById(R.id.cgl);
            aVar.Pxp.setVisibility(8);
            aVar.tkK = (ImageView) view.findViewById(R.id.dl3);
            aVar.checkBox = (CheckBox) view.findViewById(R.id.fbe);
            aVar.tkM = view.findViewById(R.id.fbf);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.tkL.setVisibility(8);
        aVar.tkJ.setVisibility(8);
        aVar.Pxp.setVisibility(8);
        aVar.Pxo.setVisibility(8);
        ca caVar = (ca) getItem(i2);
        if (caVar == null) {
            AppMethodBeat.o(35941);
        } else {
            if (!this.qoo) {
                aVar.tkI.setImageResource(R.drawable.bjn);
            } else if (!(this.Pxi instanceof ImageGalleryGridUI)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the context should be ImageGalleryGridUI");
                AppMethodBeat.o(35941);
                throw illegalArgumentException;
            } else {
                String str = caVar.field_content;
                k.b bVar = null;
                if (str != null) {
                    bVar = k.b.aD(str, caVar.field_reserved);
                }
                if (this.Pxi.Pxq == i2) {
                    aVar.tkK.setVisibility(0);
                    if (!b.co(caVar) || bVar == null || bVar.type == 3) {
                        if (bVar != null && bVar.type == 3) {
                            aVar.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j(bVar)));
                        }
                        q.bcV().a(cv(caVar), aVar.tkI, this.gzE, new com.tencent.mm.av.a.c.k() {
                            /* class com.tencent.mm.ui.chatting.gallery.c.AnonymousClass1 */

                            @Override // com.tencent.mm.av.a.c.k
                            public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                                AppMethodBeat.i(35937);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.gallery.c.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(35936);
                                        AppMethodBeat.o(35936);
                                    }
                                });
                                AppMethodBeat.o(35937);
                            }
                        });
                    } else {
                        aVar.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j(bVar)));
                        aVar.tkI.setImageResource(k(bVar));
                    }
                } else {
                    aVar.tkK.setVisibility(0);
                    aVar.tkK.setBackgroundResource(R.color.vt);
                    if (!b.co(caVar) || bVar == null || bVar.type == 3) {
                        if (bVar != null && bVar.type == 3) {
                            aVar.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j(bVar)));
                        }
                        q.bcV().a(cv(caVar), aVar.tkI, this.gzE);
                    } else {
                        aVar.Pxn.setImageDrawable(this.Pxi.getResources().getDrawable(j(bVar)));
                        aVar.tkI.setImageResource(k(bVar));
                    }
                }
                aVar.tkI.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.tkI.getMeasuredWidth();
                int measuredHeight = aVar.tkI.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    ViewGroup.LayoutParams layoutParams = aVar.tkK.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.tkK.setLayoutParams(layoutParams);
                }
                if (b.m(caVar)) {
                    if (aVar != null) {
                        aVar.tkJ.setVisibility(0);
                        com.tencent.mm.modelvideo.s cF = j.cF(caVar);
                        if (cF != null) {
                            aVar.qog.setText(Util.formatSecToMin(cF.iFw));
                        }
                    }
                } else if (b.cn(caVar)) {
                    aVar.tkL.setVisibility(0);
                } else if (b.co(caVar) && aVar != null) {
                    aVar.Pxp.setVisibility(0);
                    aVar.Pxo.setVisibility(0);
                    if (bVar != null) {
                        Log.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", Util.nullAsNil(bVar.title));
                        if (bVar.type != 24) {
                            aVar.Pxo.setText(l.b(this.mContext, Util.nullAsNil(bVar.title), aVar.Pxo.getTextSize()));
                        } else {
                            aVar.Pxo.setText(l.b(aVar.Pxo.getContext(), aVar.Pxo.getContext().getString(R.string.cd5), aVar.Pxo.getTextSize()));
                        }
                    }
                }
            }
            aVar.checkBox.setChecked(h.a.Pys.cE(caVar));
            aVar.checkBox.setTag(caVar);
            aVar.tkM.setTag(aVar);
            aVar.tkM.setOnClickListener(this);
            if (h.a.Pys.tku) {
                aVar.checkBox.setVisibility(0);
                aVar.tkM.setVisibility(0);
                aVar.tkK.setVisibility(0);
            } else {
                aVar.checkBox.setVisibility(8);
                aVar.tkM.setVisibility(8);
                aVar.tkK.setVisibility(8);
            }
            AppMethodBeat.o(35941);
        }
        return view;
    }

    private static int j(k.b bVar) {
        AppMethodBeat.i(35942);
        if (bVar == null) {
            Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689580");
            AppMethodBeat.o(35942);
            return R.raw.app_attach_file_icon_unknow_in_gird;
        } else if (bVar.type == 5 || bVar.type == 7 || bVar.type == 15) {
            AppMethodBeat.o(35942);
            return R.raw.app_attach_file_icon_url_in_gird;
        } else if (bVar.type == 3) {
            AppMethodBeat.o(35942);
            return R.raw.app_attach_file_icon_music_in_gird;
        } else if (bVar.type != 6 || !oYD.containsKey(Util.nullAsNil(bVar.iwJ))) {
            AppMethodBeat.o(35942);
            return R.raw.app_attach_file_icon_unknow_in_gird;
        } else {
            Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + oYD.get(Util.nullAsNil(bVar.iwJ)));
            int intValue = oYD.get(Util.nullAsNil(bVar.iwJ)).intValue();
            AppMethodBeat.o(35942);
            return intValue;
        }
    }

    private static int k(k.b bVar) {
        AppMethodBeat.i(35943);
        if (bVar == null) {
            Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131099932");
            AppMethodBeat.o(35943);
            return R.color.cn;
        } else if (bVar.type == 5 || bVar.type == 7 || bVar.type == 15) {
            AppMethodBeat.o(35943);
            return R.color.co;
        } else if (bVar.type != 6 || !Pxk.containsKey(Util.nullAsNil(bVar.iwJ))) {
            AppMethodBeat.o(35943);
            return R.color.cn;
        } else {
            Log.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + Pxk.get(Util.nullAsNil(bVar.iwJ)));
            int intValue = Pxk.get(Util.nullAsNil(bVar.iwJ)).intValue();
            AppMethodBeat.o(35943);
            return intValue;
        }
    }

    private static String cv(ca caVar) {
        String str;
        com.tencent.mm.pluginsdk.model.app.c bdx;
        AppMethodBeat.i(35944);
        if (caVar.cWJ() || caVar.cWL()) {
            o.bhj();
            str = t.Qx(caVar.field_imgPath);
        } else {
            str = q.bcR().d(caVar.field_imgPath, false, false);
            if (!Util.isNullOrNil(str) && !str.endsWith("hd") && com.tencent.mm.vfs.s.YS(str + "hd")) {
                str = str + "hd";
            }
        }
        Log.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", str);
        if (caVar.gDr()) {
            k.b HD = k.b.HD(caVar.field_content);
            String str2 = null;
            if (!(HD == null || HD.dCK == null || HD.dCK.length() <= 0 || (bdx = ao.cgO().bdx(HD.dCK)) == null)) {
                str2 = bdx.field_fileFullPath;
            }
            if (str2 != null) {
                str = str2;
            }
        }
        AppMethodBeat.o(35944);
        return str;
    }

    protected static class a {
        public ImageView Pxn;
        public TextView Pxo;
        public View Pxp;
        public CheckBox checkBox;
        public TextView qog;
        public ImageView tkI;
        public View tkJ;
        public ImageView tkK;
        public View tkL;
        public View tkM;

        protected a() {
        }
    }

    public final void cWH() {
        AppMethodBeat.i(35945);
        this.vtY = false;
        notifyDataSetChanged();
        AppMethodBeat.o(35945);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(35946);
        super.notifyDataSetChanged();
        this.Pxj = false;
        AppMethodBeat.o(35946);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(35947);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        a aVar = (a) view.getTag();
        if (aVar.checkBox == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35947);
            return;
        }
        ca caVar = (ca) aVar.checkBox.getTag();
        if (caVar == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35947);
            return;
        }
        h hVar = h.a.Pys;
        if (hVar.cE(caVar)) {
            hVar.cD(caVar);
        } else {
            hVar.cC(caVar);
        }
        if (h.a.Pys.cE(caVar)) {
            aVar.checkBox.setChecked(true);
            aVar.tkK.setBackgroundResource(R.color.u_);
        } else {
            aVar.checkBox.setChecked(false);
            aVar.tkK.setBackgroundResource(R.color.vt);
        }
        if (!this.vtY && h.a.Pys.tkt.size() > 1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 20, 1, true);
            this.vtY = true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(35947);
    }

    static {
        AppMethodBeat.i(35949);
        HashMap hashMap = new HashMap();
        oYD = hashMap;
        hashMap.put("avi", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("m4v", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("vob", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("mpeg", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("mpe", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("asx", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("asf", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("f4v", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("flv", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("mkv", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("wmv", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("wm", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("3gp", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("mp4", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("rmvb", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("rm", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("ra", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("ram", Integer.valueOf((int) R.raw.app_attach_file_icon_video_in_gird));
        oYD.put("mp3pro", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("vqf", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("cd", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("md", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("mod", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("vorbis", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("au", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("amr", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("silk", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("wma", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("mmf", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("mid", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("midi", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("mp3", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("aac", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("ape", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("aiff", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("aif", Integer.valueOf((int) R.raw.app_attach_file_icon_music_in_gird));
        oYD.put("doc", Integer.valueOf((int) R.raw.app_attach_file_icon_word_in_gird));
        oYD.put("docx", Integer.valueOf((int) R.raw.app_attach_file_icon_word_in_gird));
        oYD.put("ppt", Integer.valueOf((int) R.raw.app_attach_file_icon_ppt_in_gird));
        oYD.put("pptx", Integer.valueOf((int) R.raw.app_attach_file_icon_ppt_in_gird));
        oYD.put("xls", Integer.valueOf((int) R.raw.app_attach_file_icon_excel_in_gird));
        oYD.put("xlsx", Integer.valueOf((int) R.raw.app_attach_file_icon_excel_in_gird));
        oYD.put("pdf", Integer.valueOf((int) R.raw.app_attach_file_icon_pdf_in_gird));
        oYD.put("unknown", Integer.valueOf((int) R.raw.app_attach_file_icon_unknow_in_gird));
        HashMap hashMap2 = new HashMap();
        Pxk = hashMap2;
        hashMap2.put("doc", Integer.valueOf((int) R.color.cj));
        Pxk.put("docx", Integer.valueOf((int) R.color.cj));
        Pxk.put("ppt", Integer.valueOf((int) R.color.cm));
        Pxk.put("pptx", Integer.valueOf((int) R.color.cm));
        Pxk.put("xls", Integer.valueOf((int) R.color.cp));
        Pxk.put("xlsx", Integer.valueOf((int) R.color.cp));
        Pxk.put("pdf", Integer.valueOf((int) R.color.cl));
        Pxk.put("unknown", Integer.valueOf((int) R.color.cn));
        Pxk.put("mp3pro", Integer.valueOf((int) R.color.ck));
        Pxk.put("vqf", Integer.valueOf((int) R.color.ck));
        Pxk.put("cd", Integer.valueOf((int) R.color.ck));
        Pxk.put("md", Integer.valueOf((int) R.color.ck));
        Pxk.put("mod", Integer.valueOf((int) R.color.ck));
        Pxk.put("vorbis", Integer.valueOf((int) R.color.ck));
        Pxk.put("au", Integer.valueOf((int) R.color.ck));
        Pxk.put("amr", Integer.valueOf((int) R.color.ck));
        Pxk.put("silk", Integer.valueOf((int) R.color.ck));
        Pxk.put("wma", Integer.valueOf((int) R.color.ck));
        Pxk.put("mmf", Integer.valueOf((int) R.color.ck));
        Pxk.put("mid", Integer.valueOf((int) R.color.ck));
        Pxk.put("midi", Integer.valueOf((int) R.color.ck));
        Pxk.put("mp3", Integer.valueOf((int) R.color.ck));
        Pxk.put("aac", Integer.valueOf((int) R.color.ck));
        Pxk.put("ape", Integer.valueOf((int) R.color.ck));
        Pxk.put("aiff", Integer.valueOf((int) R.color.ck));
        Pxk.put("aif", Integer.valueOf((int) R.color.ck));
        AppMethodBeat.o(35949);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ ca a(ca caVar, Cursor cursor) {
        AppMethodBeat.i(35948);
        ca caVar2 = new ca();
        caVar2.convertFrom(cursor);
        AppMethodBeat.o(35948);
        return caVar2;
    }
}
