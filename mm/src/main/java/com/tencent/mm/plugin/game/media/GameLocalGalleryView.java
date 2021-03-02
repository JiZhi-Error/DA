package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.gallery.ui.a;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.game.media.a;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLocalGalleryView extends FrameLayout {
    static final int xAV = ("GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 65535);
    static final int xAW = ("GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 65535);
    private boolean gOZ;
    private int xAD = 0;
    private RecyclerView xAX;
    c xAY;
    private TextView xAZ;
    private Button xBa;
    private int xBb;
    private boolean xBc = false;
    private boolean xBd = false;

    /* access modifiers changed from: package-private */
    public interface b {
        void Ir(int i2);
    }

    static /* synthetic */ void a(GameLocalGalleryView gameLocalGalleryView, int i2) {
        AppMethodBeat.i(204115);
        gameLocalGalleryView.gK(i2, 2);
        AppMethodBeat.o(204115);
    }

    static {
        AppMethodBeat.i(41027);
        AppMethodBeat.o(41027);
    }

    public GameLocalGalleryView(Context context) {
        super(context);
        AppMethodBeat.i(41016);
        init();
        AppMethodBeat.o(41016);
    }

    public GameLocalGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41017);
        init();
        AppMethodBeat.o(41017);
    }

    public GameLocalGalleryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(41018);
        init();
        AppMethodBeat.o(41018);
    }

    private void init() {
        AppMethodBeat.i(41019);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.as7, (ViewGroup) this, false);
        this.xAX = (RecyclerView) inflate.findViewById(R.id.dh_);
        this.xAX.setLayoutManager(new GameGridLayoutManager(getContext()));
        this.xAX.a(new a());
        this.xAY = new c(getContext());
        this.xAX.setAdapter(this.xAY);
        this.xAZ = (TextView) inflate.findViewById(R.id.dhd);
        this.xAZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.AnonymousClass1 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(40997);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c cVar = GameLocalGalleryView.this.xAY;
                if (cVar.xnp != null) {
                    i2 = cVar.xnp.size();
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    Intent intent = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
                    intent.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.this.xAY.dRL());
                    intent.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.this.xAY.xnp);
                    intent.putExtra("max_select_count", GameLocalGalleryView.this.xBb);
                    intent.putExtra("send_raw_img", false);
                    com.tencent.mm.br.c.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", intent, GameLocalGalleryView.xAW);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_game_haowan_text", true);
                    ((Activity) GameLocalGalleryView.this.getContext()).setResult(-1, intent2);
                    ((Activity) GameLocalGalleryView.this.getContext()).finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(40997);
            }
        });
        this.xBa = (Button) inflate.findViewById(R.id.dhb);
        this.xBa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(40998);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList<GalleryItem.MediaItem> arrayList = GameLocalGalleryView.this.xAY.xnp;
                ArrayList arrayList2 = new ArrayList();
                Iterator<GalleryItem.MediaItem> it = arrayList.iterator();
                while (it.hasNext()) {
                    GalleryItem.MediaItem next = it.next();
                    if (!next.mMimeType.equals("edit") || Util.isNullOrNil(next.xiY)) {
                        arrayList2.add(next.xiW);
                    } else {
                        arrayList2.add(next.xiY);
                    }
                }
                if (!Util.isNullOrNil(arrayList2)) {
                    GameLocalGalleryView.dUo();
                }
                Intent intent = new Intent();
                intent.putExtra("CropImage_OutputPath_List", arrayList2);
                ((Activity) GameLocalGalleryView.this.getContext()).setResult(-1, intent);
                ((Activity) GameLocalGalleryView.this.getContext()).finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(40998);
            }
        });
        this.xAY.xBf = new b() {
            /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.game.media.GameLocalGalleryView.b
            public final void Ir(int i2) {
                AppMethodBeat.i(40999);
                if (i2 > 0) {
                    GameLocalGalleryView.this.xBa.setText(GameLocalGalleryView.this.getResources().getString(R.string.dqk, Integer.valueOf(i2), Integer.valueOf(GameLocalGalleryView.this.xBb)));
                    GameLocalGalleryView.this.xBa.setEnabled(true);
                    GameLocalGalleryView.this.xAZ.setVisibility(0);
                    GameLocalGalleryView.this.xAZ.setText(GameLocalGalleryView.this.getResources().getString(R.string.dqm));
                    AppMethodBeat.o(40999);
                    return;
                }
                GameLocalGalleryView.this.xBa.setText(GameLocalGalleryView.this.getResources().getString(R.string.dqj));
                GameLocalGalleryView.this.xBa.setEnabled(false);
                if (!GameLocalGalleryView.this.xBc) {
                    GameLocalGalleryView.this.xAZ.setVisibility(0);
                    GameLocalGalleryView.this.xAZ.setText(GameLocalGalleryView.this.getResources().getString(R.string.dql));
                    AppMethodBeat.o(40999);
                    return;
                }
                GameLocalGalleryView.this.xAZ.setVisibility(8);
                AppMethodBeat.o(40999);
            }
        };
        addView(inflate, -1, -1);
        AppMethodBeat.o(41019);
    }

    public final void dUl() {
        AppMethodBeat.i(41020);
        if (!this.gOZ) {
            gK(0, 1);
        }
        this.gOZ = true;
        AppMethodBeat.o(41020);
    }

    public final void c(boolean z, boolean z2, int i2) {
        AppMethodBeat.i(204114);
        this.xBc = z;
        if (this.xBc && this.xAZ != null) {
            this.xAZ.setVisibility(8);
        }
        this.xBd = z2;
        this.xAD = i2;
        AppMethodBeat.o(204114);
    }

    public void setQueryType(int i2) {
        AppMethodBeat.i(41021);
        this.xAY.xjo = i2;
        a.a(i2, new a.c() {
            /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.game.media.a.c
            public final void aP(LinkedList<GalleryItem.MediaItem> linkedList) {
                AppMethodBeat.i(41000);
                ArrayList arrayList = new ArrayList();
                if (linkedList != null) {
                    arrayList.addAll(linkedList);
                }
                MMHandlerThread.postToMainThread(new Runnable(arrayList) {
                    /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.AnonymousClass3 */
                    final /* synthetic */ ArrayList xBi;

                    {
                        this.xBi = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(41005);
                        c.this.xno.clear();
                        if (this.xBi != null) {
                            c.this.xno.addAll(this.xBi);
                        }
                        c.this.atj.notifyChanged();
                        AppMethodBeat.o(41005);
                    }
                });
                AppMethodBeat.o(41000);
            }
        });
        AppMethodBeat.o(41021);
    }

    public void setSelectLimitCount(int i2) {
        this.xAY.xnn = i2;
        this.xBb = i2;
    }

    public final void dUm() {
        AppMethodBeat.i(41022);
        c cVar = this.xAY;
        cVar.xnp.clear();
        if (cVar.xBf != null) {
            cVar.xBf.Ir(cVar.xnp.size());
        }
        GameLocalGalleryView.this.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(41006);
                c.this.atj.notifyChanged();
                AppMethodBeat.o(41006);
            }
        }, 500);
        AppMethodBeat.o(41022);
    }

    static void dUn() {
        AppMethodBeat.i(41023);
        a.Od(2);
        AppMethodBeat.o(41023);
    }

    /* access modifiers changed from: package-private */
    public class c extends RecyclerView.a<d> {
        private Context mContext;
        b xBf;
        int xjo;
        int xnn;
        private ArrayList<GalleryItem.MediaItem> xno = new ArrayList<>();
        ArrayList<GalleryItem.MediaItem> xnp = new ArrayList<>();
        private View.OnClickListener xnv = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.AnonymousClass6 */

            public final void onClick(View view) {
                boolean z;
                boolean z2;
                AppMethodBeat.i(41008);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(view.getTag(R.id.fbf) instanceof Integer)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(41008);
                    return;
                }
                Integer num = (Integer) view.getTag(R.id.fbf);
                if (num == null) {
                    Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(41008);
                    return;
                }
                GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) c.this.xno.get(num.intValue());
                if (mediaItem == null || Util.isNullOrNil(mediaItem.xiW)) {
                    Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(41008);
                    return;
                }
                Log.i("MicroMsg.GameLocalMediaView", "click Image path:" + mediaItem.xiW);
                if (c.this.xnp.contains(mediaItem)) {
                    c.this.xnp.remove(mediaItem);
                    z = true;
                    z2 = false;
                } else {
                    if (e.dQK().mcq == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                        s.boW(mediaItem.xiW);
                        if (!((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amz(mediaItem.xiW)) {
                            h.cD(c.this.mContext, c.this.mContext.getString(R.string.dmp));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(41008);
                            return;
                        }
                    }
                    if (c.this.xnp.size() < c.this.xnn) {
                        c.this.xnp.add(mediaItem);
                        z = false;
                        z2 = false;
                    } else {
                        z = true;
                        z2 = true;
                    }
                }
                if (z2) {
                    if (c.this.xjo == 1) {
                        h.cD(c.this.mContext, c.this.mContext.getResources().getQuantityString(R.plurals.o, c.this.xnn, Integer.valueOf(c.this.xnn)));
                    } else if (c.this.xjo == 2) {
                        h.cD(c.this.mContext, c.this.mContext.getResources().getQuantityString(R.plurals.q, c.this.xnn, Integer.valueOf(c.this.xnn)));
                    } else {
                        h.cD(c.this.mContext, c.this.mContext.getResources().getQuantityString(R.plurals.p, c.this.xnn, Integer.valueOf(c.this.xnn)));
                    }
                }
                if (true == z) {
                    ((CheckBox) view.getTag(R.id.fbe)).setChecked(false);
                    ((View) view.getTag(R.id.fbr)).setVisibility(0);
                    ((View) view.getTag(R.id.fbr)).setBackgroundResource(R.color.vt);
                } else {
                    ((CheckBox) view.getTag(R.id.fbe)).setChecked(true);
                    ((View) view.getTag(R.id.fbr)).setVisibility(0);
                    ((View) view.getTag(R.id.fbr)).setBackgroundResource(R.color.ad);
                    GameLocalGalleryView.a(GameLocalGalleryView.this, 1);
                }
                if (c.this.xBf != null) {
                    c.this.xBf.Ir(c.this.xnp.size());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41008);
            }
        };

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(d dVar, int i2) {
            AppMethodBeat.i(41013);
            d dVar2 = dVar;
            Log.i("MicroMsg.GameLocalMediaView", "onBindViewHolder");
            final GalleryItem.MediaItem mediaItem = this.xno.get(i2);
            if (mediaItem != null) {
                dVar2.xrw.setVisibility(0);
                if (mediaItem.getType() == 2) {
                    dVar2.xrx.setVisibility(0);
                    a.g.a(dVar2.xry, (GalleryItem.VideoMediaItem) mediaItem);
                } else {
                    dVar2.xrx.setVisibility(8);
                }
                if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
                    dVar2.xrA.setVisibility(0);
                } else {
                    dVar2.xrA.setVisibility(8);
                }
                String aQn = mediaItem.aQn();
                String str = mediaItem.xiW;
                if (!Util.isNullOrNil(aQn) || !Util.isNullOrNil(str)) {
                    if (mediaItem.getType() == 1) {
                        dVar2.tkM.setVisibility(0);
                        dVar2.checkBox.setVisibility(0);
                        dVar2.tkM.setTag(R.id.fbf, Integer.valueOf(i2));
                    } else {
                        dVar2.tkM.setVisibility(8);
                        dVar2.checkBox.setVisibility(8);
                    }
                    final ImageView imageView = dVar2.xrw;
                    com.tencent.mm.plugin.gallery.ui.h.a(dVar2.xdY, mediaItem.getType(), aQn, str, mediaItem.xiZ, new h.a() {
                        /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.gallery.ui.h.a
                        public final void dSs() {
                            AppMethodBeat.i(41003);
                            if (imageView != null) {
                                imageView.setVisibility(8);
                            }
                            AppMethodBeat.o(41003);
                        }
                    }, mediaItem.xja);
                    if (this.xnp.contains(mediaItem)) {
                        dVar2.checkBox.setChecked(true);
                        dVar2.xnz.setVisibility(0);
                        dVar2.xnz.setBackgroundResource(R.color.u_);
                    } else {
                        dVar2.checkBox.setChecked(false);
                        dVar2.xnz.setVisibility(0);
                        dVar2.xnz.setBackgroundResource(R.color.vt);
                    }
                    dVar2.aus.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(41004);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (mediaItem.getType() != 2) {
                                ArrayList<GalleryItem.MediaItem> NJ = c.this.NJ(mediaItem.getType());
                                e.ao(NJ);
                                Intent intent = new Intent(c.this.mContext, ImagePreviewUI.class);
                                intent.putStringArrayListExtra("preview_image_list", c.this.dRL());
                                intent.putParcelableArrayListExtra("preview_media_item_list", c.this.xnp);
                                intent.putExtra("preview_all", true);
                                intent.putExtra("preview_position", NJ.indexOf(mediaItem));
                                intent.putExtra("send_raw_img", false);
                                intent.putExtra("max_select_count", c.this.xnn);
                                com.tencent.mm.br.c.b(c.this.mContext, "gallery", ".ui.ImagePreviewUI", intent, GameLocalGalleryView.xAW);
                            } else if (c.this.xnp.size() != 0) {
                                com.tencent.mm.ui.base.h.cD(GameLocalGalleryView.this.getContext(), com.tencent.mm.cb.a.aI(GameLocalGalleryView.this.getContext(), R.string.dm0));
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(41004);
                                return;
                            } else {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("game_straight_to_publish", GameLocalGalleryView.this.xBd);
                                ((com.tencent.mm.plugin.game.api.g) g.af(com.tencent.mm.plugin.game.api.g.class)).a(c.this.mContext, mediaItem.xiW, GameLocalGalleryView.xAV, bundle, GameLocalGalleryView.this.xAD);
                                GameLocalGalleryView.a(GameLocalGalleryView.this, 2);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(41004);
                        }
                    });
                } else {
                    Log.e("MicroMsg.GameLocalMediaView", "null or nil filepath: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(41013);
                    return;
                }
            }
            AppMethodBeat.o(41013);
        }

        c(Context context) {
            AppMethodBeat.i(41009);
            this.mContext = context;
            this.xno.add(new GalleryItem.ImageMediaItem());
            Log.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
            AppMethodBeat.o(41009);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(41010);
            Log.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", Integer.valueOf(this.xno.size()));
            int size = this.xno.size();
            AppMethodBeat.o(41010);
            return size;
        }

        public final ArrayList<String> dRL() {
            AppMethodBeat.i(41011);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<GalleryItem.MediaItem> it = this.xnp.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().xiW);
            }
            AppMethodBeat.o(41011);
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public final void aq(ArrayList<String> arrayList) {
            int indexOf;
            GalleryItem.MediaItem mediaItem;
            AppMethodBeat.i(41012);
            Log.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", this.xnp);
            this.xnp.clear();
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(0, 0, next, next, "");
                    if (e.dQM() == null || (indexOf = e.dQM().indexOf(a2)) < 0 || (mediaItem = e.dQM().get(indexOf)) == null || mediaItem.getType() != 2) {
                        Log.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
                        this.xnp.add(GalleryItem.MediaItem.a(1, 0, next, "", ""));
                    } else {
                        this.xnp.add(GalleryItem.MediaItem.a(2, 0, next, "", ""));
                    }
                }
            }
            Log.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", this.xnp);
            if (this.xBf != null) {
                this.xBf.Ir(this.xnp.size());
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.GameLocalGalleryView.c.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(41007);
                    c.this.atj.notifyChanged();
                    AppMethodBeat.o(41007);
                }
            });
            AppMethodBeat.o(41012);
        }

        /* access modifiers changed from: package-private */
        public final ArrayList<GalleryItem.MediaItem> NJ(int i2) {
            AppMethodBeat.i(204113);
            ArrayList<GalleryItem.MediaItem> arrayList = new ArrayList<>();
            Iterator<GalleryItem.MediaItem> it = this.xno.iterator();
            while (it.hasNext()) {
                GalleryItem.MediaItem next = it.next();
                if (next.getType() == i2) {
                    arrayList.add(next);
                }
            }
            AppMethodBeat.o(204113);
            return arrayList;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ d a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(41014);
            Log.i("MicroMsg.GameLocalMediaView", "onCreateViewHolder");
            d dVar = new d(LayoutInflater.from(this.mContext).inflate(R.layout.arf, viewGroup, false));
            dVar.tkM.setOnClickListener(this.xnv);
            AppMethodBeat.o(41014);
            return dVar;
        }
    }

    class d extends RecyclerView.v {
        CheckBox checkBox;
        View tkM;
        ImageView xdY;
        ImageView xnz;
        ImageView xrA;
        ImageView xrw;
        RelativeLayout xrx;
        TextView xry;

        public d(View view) {
            super(view);
            AppMethodBeat.i(41015);
            this.xrw = (ImageView) view.findViewById(R.id.fbw);
            this.xdY = (ImageView) view.findViewById(R.id.fc1);
            this.xrx = (RelativeLayout) view.findViewById(R.id.j5b);
            this.xry = (TextView) view.findViewById(R.id.j5d);
            this.checkBox = (CheckBox) view.findViewById(R.id.fbe);
            this.tkM = view.findViewById(R.id.fbf);
            this.xnz = (ImageView) view.findViewById(R.id.fbr);
            this.tkM.setTag(R.id.fbe, this.checkBox);
            this.tkM.setTag(R.id.fbr, this.xnz);
            this.xrA = (ImageView) view.findViewById(R.id.bvx);
            AppMethodBeat.o(41015);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.h {
        private int mSize = at.fromDPToPix(MMApplicationContext.getContext(), 3);

        public a() {
            AppMethodBeat.i(41001);
            AppMethodBeat.o(41001);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(41002);
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            int i2 = ((GridLayoutManager) recyclerView.getLayoutManager()).apM;
            int bw = RecyclerView.bw(view);
            int i3 = layoutParams.apT;
            Log.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", Integer.valueOf(layoutParams.apU), Integer.valueOf(i2), Integer.valueOf(i3));
            if (bw < i2) {
                if (i3 == 0) {
                    rect.set(0, 0, 0, 0);
                    AppMethodBeat.o(41002);
                    return;
                }
                rect.set(this.mSize, 0, 0, 0);
                AppMethodBeat.o(41002);
            } else if (i3 == 0) {
                rect.set(0, this.mSize, 0, 0);
                AppMethodBeat.o(41002);
            } else {
                rect.set(this.mSize, this.mSize, 0, 0);
                AppMethodBeat.o(41002);
            }
        }
    }

    private void gK(int i2, int i3) {
        AppMethodBeat.i(41024);
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8767, i2, i3, this.xAD, com.tencent.mm.game.report.b.a.c(7, new HashMap()));
        AppMethodBeat.o(41024);
    }

    static /* synthetic */ void dUo() {
        AppMethodBeat.i(41025);
        a.Od(2);
        AppMethodBeat.o(41025);
    }
}
