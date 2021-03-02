package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView extends LinearLayout implements AdapterView.OnItemClickListener, i.a {
    boolean jT = false;
    private a xpR = null;
    FrameLayout xpS;
    private View xpT;
    private ListView xpU;
    private b xpV;
    boolean xpW = false;
    i.a xpX;
    private LinkedList<GalleryItem.PrivateAlbumItem> xpY = new LinkedList<>();
    private GalleryItem.PrivateAlbumItem xpZ = null;
    b xqa;

    public interface a {
        void c(GalleryItem.AlbumItem albumItem);
    }

    public interface b {
        void pB(boolean z);
    }

    static /* synthetic */ void c(ImageFolderMgrView imageFolderMgrView) {
        AppMethodBeat.i(111544);
        imageFolderMgrView.pD(false);
        AppMethodBeat.o(111544);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111536);
        setOrientation(1);
        this.xpS = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.xpS.setVisibility(8);
        addView(this.xpS, layoutParams);
        this.xpT = new View(getContext());
        this.xpT.setBackgroundColor(-872415232);
        this.xpT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(111532);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ImageFolderMgrView.c(ImageFolderMgrView.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111532);
            }
        });
        this.xpS.addView(this.xpT, new FrameLayout.LayoutParams(-1, -1));
        RoundedCornerFrameLayout roundedCornerFrameLayout = new RoundedCornerFrameLayout(getContext());
        roundedCornerFrameLayout.s(0.0f, 0.0f, (float) at.fromDPToPix(getContext(), 8), (float) at.fromDPToPix(getContext(), 8));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.a8c);
        layoutParams2.gravity = 48;
        this.xpS.addView(roundedCornerFrameLayout, layoutParams2);
        this.xpU = new ListView(getContext());
        this.xpU.setCacheColorHint(0);
        this.xpU.setOnItemClickListener(this);
        roundedCornerFrameLayout.addView(this.xpU, new RelativeLayout.LayoutParams(-1, -2));
        this.xpV = new b(getContext());
        this.xpU.setAdapter((ListAdapter) this.xpV);
        this.xpX = new i.a() {
            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.gallery.model.i.a
            public final void aL(LinkedList<GalleryItem.AlbumItem> linkedList) {
                boolean z;
                AppMethodBeat.i(173780);
                Object[] objArr = new Object[1];
                objArr[0] = linkedList != null ? Integer.valueOf(linkedList.size()) : "res is null.";
                Log.i("MicroMsg.ImageFolderMgrView", "onGetPrivateAlbum, %s.", objArr);
                e.dQK().c(ImageFolderMgrView.this.xpX);
                if (linkedList != null && linkedList.size() > 0) {
                    Iterator<GalleryItem.AlbumItem> it = linkedList.iterator();
                    while (it.hasNext()) {
                        GalleryItem.AlbumItem next = it.next();
                        if (next instanceof GalleryItem.PrivateAlbumItem) {
                            GalleryItem.PrivateAlbumItem privateAlbumItem = (GalleryItem.PrivateAlbumItem) next;
                            s.b bVar = privateAlbumItem.xjf.xjN;
                            if (bVar == null) {
                                z = false;
                            } else {
                                z = bVar.xjQ;
                            }
                            if (z) {
                                ImageFolderMgrView.this.xpZ = privateAlbumItem;
                            } else {
                                ImageFolderMgrView.this.xpY.add(privateAlbumItem);
                            }
                        }
                    }
                    Log.i("MicroMsg.ImageFolderMgrView", "filter res: %s.", Integer.valueOf(ImageFolderMgrView.this.xpY.size()));
                    if (!ImageFolderMgrView.this.isInLayout() && (ImageFolderMgrView.this.xpZ != null || ImageFolderMgrView.this.xpY.size() > 0)) {
                        e.dQL().postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(173779);
                                ImageFolderMgrView.this.xpV.a(ImageFolderMgrView.this.xpZ, ImageFolderMgrView.this.xpY);
                                ImageFolderMgrView.this.xpZ = null;
                                ImageFolderMgrView.this.xpY.clear();
                                ImageFolderMgrView.this.xpV.notifyDataSetChanged();
                                AppMethodBeat.o(173779);
                            }
                        });
                    }
                }
                AppMethodBeat.o(173780);
            }
        };
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass5 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(179469);
                Log.i("MicroMsg.ImageFolderMgrView", "onPreDraw.");
                if (ImageFolderMgrView.this.xpZ != null || ImageFolderMgrView.this.xpY.size() > 0) {
                    e.dQL().postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(179468);
                            ImageFolderMgrView.this.xpV.a(ImageFolderMgrView.this.xpZ, ImageFolderMgrView.this.xpY);
                            ImageFolderMgrView.this.xpZ = null;
                            ImageFolderMgrView.this.xpY.clear();
                            ImageFolderMgrView.this.xpV.notifyDataSetChanged();
                            AppMethodBeat.o(179468);
                        }
                    });
                    AppMethodBeat.o(179469);
                    return false;
                }
                AppMethodBeat.o(179469);
                return true;
            }
        });
        AppMethodBeat.o(111536);
    }

    public final void dSg() {
        AppMethodBeat.i(111537);
        pD(!this.jT);
        AppMethodBeat.o(111537);
    }

    private void pD(boolean z) {
        AppMethodBeat.i(111538);
        if (this.jT == z) {
            Log.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.jT));
            AppMethodBeat.o(111538);
        } else if (this.xpW) {
            Log.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.o(111538);
        } else if (this.jT) {
            dSi();
            AppMethodBeat.o(111538);
        } else {
            dSh();
            AppMethodBeat.o(111538);
        }
    }

    private void dSh() {
        AppMethodBeat.i(111539);
        this.xpW = true;
        this.xpS.setVisibility(0);
        this.xpT.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.br));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dn);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass1 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(111530);
                ImageFolderMgrView.this.jT = true;
                ImageFolderMgrView.this.xpW = false;
                if (ImageFolderMgrView.this.xqa != null) {
                    ImageFolderMgrView.this.xqa.pB(true);
                }
                AppMethodBeat.o(111530);
            }
        });
        this.xpU.startAnimation(loadAnimation);
        AppMethodBeat.o(111539);
    }

    private void dSi() {
        AppMethodBeat.i(111540);
        this.xpW = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dr);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(111531);
                ImageFolderMgrView.this.xpS.setVisibility(8);
                ImageFolderMgrView.this.jT = false;
                ImageFolderMgrView.this.xpW = false;
                if (ImageFolderMgrView.this.xqa != null) {
                    ImageFolderMgrView.this.xqa.pB(false);
                }
                AppMethodBeat.o(111531);
            }
        });
        this.xpU.startAnimation(loadAnimation);
        this.xpT.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bs));
        AppMethodBeat.o(111540);
    }

    public void setListener(a aVar) {
        this.xpR = aVar;
    }

    @Override // com.tencent.mm.plugin.gallery.model.i.a
    public final void aL(LinkedList<GalleryItem.AlbumItem> linkedList) {
        AppMethodBeat.i(111541);
        Log.i("MicroMsg.ImageFolderMgrView", "onQueryAlbumFinished, %s, size: %s.", this, Integer.valueOf(linkedList.size()));
        e.dQK().b(this);
        final LinkedList linkedList2 = new LinkedList();
        Iterator<GalleryItem.AlbumItem> it = linkedList.iterator();
        while (it.hasNext()) {
            GalleryItem.AlbumItem next = it.next();
            if (com.tencent.mm.vfs.s.YS(next.aQn())) {
                linkedList2.add(next);
            }
        }
        e.dQL().postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(179470);
                ImageFolderMgrView.this.xpV.xpj = linkedList2;
                ImageFolderMgrView.this.xpV.notifyDataSetChanged();
                AppMethodBeat.o(179470);
            }

            public final String toString() {
                AppMethodBeat.i(179471);
                String str = super.toString() + "|onQueryAlbumFinished";
                AppMethodBeat.o(179471);
                return str;
            }
        });
        AppMethodBeat.o(111541);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(111542);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        GalleryItem.AlbumItem NN = this.xpV.NN(i2);
        if (NN == null) {
            Log.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(i2)));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(111542);
            return;
        }
        this.xpT.performClick();
        if (this.xpR != null) {
            this.xpR.c(NN);
        }
        this.xpV.xpk = Util.nullAs(NN.albumName, "");
        this.xpV.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(111542);
    }

    public void setFavItemCount(int i2) {
        AppMethodBeat.i(111543);
        this.xpV.xpl = i2;
        c cVar = new c((byte) 0);
        cVar.xoS = new WeakReference<>(this.xpV);
        e.dQL().postToMainThread(cVar);
        AppMethodBeat.o(111543);
    }

    /* access modifiers changed from: package-private */
    public static class c implements Runnable {
        WeakReference<b> xoS;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void run() {
            b bVar;
            AppMethodBeat.i(111535);
            if (!(this.xoS == null || (bVar = this.xoS.get()) == null)) {
                bVar.notifyDataSetChanged();
            }
            AppMethodBeat.o(111535);
        }
    }

    public void setOnFolderStateChanged(b bVar) {
        this.xqa = bVar;
    }

    public String getSelectedAlbumName() {
        return this.xpV.xpk;
    }
}
