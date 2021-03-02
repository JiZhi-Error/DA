package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends BaseAdapter {
    private Context mContext;
    LinkedList<GalleryItem.AlbumItem> xpj;
    String xpk = "";
    volatile int xpl;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(111500);
        GalleryItem.AlbumItem NN = NN(i2);
        AppMethodBeat.o(111500);
        return NN;
    }

    public b(Context context) {
        AppMethodBeat.i(111496);
        this.mContext = context;
        this.xpj = new LinkedList<>();
        AppMethodBeat.o(111496);
    }

    public final void a(GalleryItem.PrivateAlbumItem privateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> linkedList) {
        int i2;
        AppMethodBeat.i(179460);
        if (this.xpj != null && (privateAlbumItem != null || this.xpj.size() > 0)) {
            if (privateAlbumItem != null) {
                Log.i("MicroMsg.GalleryAdapter", "add favorite album item.");
                if (!Util.isNullOrNil(this.xpj)) {
                    i2 = 0;
                    int i3 = -1;
                    while (true) {
                        if (i2 >= this.xpj.size()) {
                            i2 = i3;
                            break;
                        }
                        GalleryItem.AlbumItem albumItem = this.xpj.get(i2);
                        if (albumItem.UXe) {
                            break;
                        }
                        if (albumItem.UXd) {
                            i3 = i2;
                        }
                        i2++;
                    }
                } else {
                    i2 = -1;
                }
                int i4 = i2 + 1;
                if (i4 < this.xpj.size()) {
                    this.xpj.add(i4, privateAlbumItem);
                } else {
                    this.xpj.add(privateAlbumItem);
                }
            }
            if (linkedList.size() > 0) {
                Log.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", Integer.valueOf(linkedList.size()));
                this.xpj.addAll(linkedList);
            }
        }
        AppMethodBeat.o(179460);
    }

    public final int getCount() {
        AppMethodBeat.i(111497);
        int size = this.xpj.size();
        AppMethodBeat.o(111497);
        return size;
    }

    public final GalleryItem.AlbumItem NN(int i2) {
        AppMethodBeat.i(111498);
        GalleryItem.AlbumItem albumItem = this.xpj.get(i2);
        AppMethodBeat.o(111498);
        return albumItem;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(111499);
        Log.i("MicroMsg.GalleryAdapter", "duanyi test getView:".concat(String.valueOf(i2)));
        GalleryItem.AlbumItem NN = NN(i2);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bol, viewGroup, false);
            a aVar2 = new a((byte) 0);
            aVar2.xdY = (ImageView) view.findViewById(R.id.d7u);
            aVar2.jBR = (TextView) view.findViewById(R.id.d7p);
            aVar2.tlC = (ImageView) view.findViewById(R.id.j5b);
            aVar2.xpr = (TextView) view.findViewById(R.id.d7l);
            aVar2.xps = (ImageView) view.findViewById(R.id.d7t);
            aVar2.xpt = view.findViewById(R.id.d7v);
            aVar2.xpu = view.findViewById(R.id.d7n);
            aVar2.xpv = view.findViewById(R.id.d7o);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.xpk.equals(NN.albumName)) {
            aVar.xps.setVisibility(0);
        } else {
            aVar.xps.setVisibility(4);
        }
        aVar.xpu.setVisibility(0);
        aVar.xpv.setVisibility(8);
        if (NN.UXd || NN.UXe) {
            int i6 = 0;
            if (NN.UXd) {
                Iterator<GalleryItem.AlbumItem> it = this.xpj.iterator();
                while (it.hasNext()) {
                    GalleryItem.AlbumItem next = it.next();
                    if (next.UXd || next.UXe || next.dJl <= 0) {
                        i5 = i6;
                    } else {
                        i5 = next.dJl + i6;
                    }
                    i6 = i5;
                }
                i3 = i6;
            } else {
                Iterator<GalleryItem.AlbumItem> it2 = this.xpj.iterator();
                while (it2.hasNext()) {
                    GalleryItem.AlbumItem next2 = it2.next();
                    if (next2.UXd || next2.UXe || next2.xiP <= 0) {
                        i4 = i6;
                    } else {
                        i4 = next2.xiP + i6;
                    }
                    i6 = i4;
                }
                i3 = i6;
            }
        } else {
            i3 = NN.dJl;
        }
        if (i2 == 0) {
            aVar.xdY.setImageResource(R.drawable.ckb);
            if (NN.UXc != null) {
                h.a(aVar.xdY, NN.dRj(), NN.aQn(), NN.dRh(), NN.dRi(), i2, NN.hVP());
            }
            aVar.xdY.setVisibility(0);
            if (e.dQK().xjo == 1) {
                NN.nickName = MMApplicationContext.getContext().getString(R.string.dlh);
            } else if (e.dQK().xjo == 3) {
                NN.nickName = MMApplicationContext.getContext().getString(R.string.dli);
            } else {
                NN.nickName = MMApplicationContext.getContext().getString(R.string.dlj);
            }
            aVar.jBR.setText(NN.nickName);
            aVar.jBR.setVisibility(0);
            aVar.xpr.setVisibility(0);
            if (i3 > 0) {
                aVar.xpr.setText(this.mContext.getString(R.string.dlm, Integer.valueOf(i3)));
            } else {
                aVar.xpr.setText("");
            }
            AppMethodBeat.o(111499);
        } else {
            aVar.xdY.setVisibility(0);
            aVar.jBR.setVisibility(0);
            aVar.jBR.setText(NN.nickName);
            aVar.xpr.setVisibility(0);
            if (i3 > 0) {
                aVar.xpr.setText(this.mContext.getString(R.string.dlm, Integer.valueOf(i3)));
            } else {
                aVar.xpr.setText("");
                i iVar = e.dQK().xjn;
                if (NN.UXf && iVar != null && !iVar.isCancelled()) {
                    final AtomicReference atomicReference = new AtomicReference(NN);
                    e.dQL().as(new Runnable() {
                        /* class com.tencent.mm.plugin.gallery.ui.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(257747);
                            GalleryItem.AlbumItem albumItem = (GalleryItem.AlbumItem) atomicReference.get();
                            if (albumItem == null) {
                                AppMethodBeat.o(257747);
                                return;
                            }
                            i iVar = e.dQK().xjn;
                            if (albumItem.UXf && iVar != null && !iVar.isCancelled()) {
                                try {
                                    final int size = iVar.a(albumItem.albumName, 3, null, System.currentTimeMillis()).size();
                                    final int size2 = iVar.a(albumItem.albumName, 2, null, System.currentTimeMillis()).size();
                                    e.dQL().postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.gallery.ui.b.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(257746);
                                            GalleryItem.AlbumItem albumItem = (GalleryItem.AlbumItem) atomicReference.get();
                                            if (albumItem == null) {
                                                AppMethodBeat.o(257746);
                                                return;
                                            }
                                            i iVar = e.dQK().xjn;
                                            if (albumItem.UXf && iVar != null && !iVar.isCancelled()) {
                                                albumItem.dJl = size;
                                                albumItem.xiP = size2;
                                                albumItem.UXf = false;
                                                b.this.notifyDataSetChanged();
                                            }
                                            AppMethodBeat.o(257746);
                                        }
                                    });
                                    AppMethodBeat.o(257747);
                                    return;
                                } catch (Throwable th) {
                                    Log.printErrStackTrace("MicroMsg.GalleryAdapter", th, "counting album size fail", new Object[0]);
                                }
                            }
                            AppMethodBeat.o(257747);
                        }
                    });
                }
            }
            aVar.xpt.setVisibility(8);
            String aQn = NN.aQn();
            if (!Util.isNullOrNil(aQn)) {
                h.a(aVar.xdY, NN.dRj(), aQn, NN.dRh(), NN.dRi(), i2, NN.hVP());
            } else if (NN.UXc == null || NN.UXc.getType() != 2) {
                Log.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.xdY.setVisibility(8);
                aVar.jBR.setVisibility(8);
            } else {
                h.a(aVar.xdY, NN.dRj(), (String) null, NN.dRh(), NN.dRi(), i2, NN.hVP());
            }
            AppMethodBeat.o(111499);
        }
        return view;
    }

    static class a {
        public TextView jBR;
        public ImageView tlC;
        public ImageView xdY;
        public TextView xpr;
        public ImageView xps;
        public View xpt;
        View xpu;
        View xpv;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
