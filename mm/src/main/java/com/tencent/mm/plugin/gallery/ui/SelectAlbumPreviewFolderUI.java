package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI extends MMActivity implements i.a {
    ArrayList<GalleryItem.AlbumItem> xrD = new ArrayList<>(10);
    private a xrE;
    private RecyclerView xrF;
    GalleryItem.AlbumItem xrG;
    private String xrH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectAlbumPreviewFolderUI() {
        AppMethodBeat.i(111665);
        AppMethodBeat.o(111665);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111666);
        super.onCreate(bundle);
        e.dQK().b(this);
        e.dQK().a(this);
        e.dQK().dRr();
        this.xrF = (RecyclerView) findViewById(R.id.d7r);
        this.xrE = new a(this);
        this.xrF.setLayoutManager(new LinearLayoutManager());
        this.xrF.setAdapter(this.xrE);
        this.xrH = getIntent().getStringExtra("select_folder_name");
        this.xrG = new GalleryItem.AlbumItem("", 0);
        this.xrG.UXc = new GalleryItem.ImageMediaItem();
        setMMTitle(Util.nullAsNil(getString(R.string.up)));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111658);
                SelectAlbumPreviewFolderUI.this.finish();
                AppMethodBeat.o(111658);
                return false;
            }
        });
        AppMethodBeat.o(111666);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(111667);
        super.onDestroy();
        e.dQK().b(this);
        AppMethodBeat.o(111667);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpn;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(111668);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(111668);
    }

    @Override // com.tencent.mm.plugin.gallery.model.i.a
    public final void aL(final LinkedList<GalleryItem.AlbumItem> linkedList) {
        AppMethodBeat.i(111669);
        e.dQL().postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(111659);
                SelectAlbumPreviewFolderUI.this.xrD.addAll(linkedList);
                SelectAlbumPreviewFolderUI.this.xrE.atj.notifyChanged();
                AppMethodBeat.o(111659);
            }
        });
        AppMethodBeat.o(111669);
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<b> implements View.OnClickListener {
        Context mContext;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            GalleryItem.AlbumItem albumItem;
            AppMethodBeat.i(111662);
            b bVar2 = bVar;
            SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI = SelectAlbumPreviewFolderUI.this;
            if (i2 == 0) {
                albumItem = selectAlbumPreviewFolderUI.xrG;
            } else {
                albumItem = selectAlbumPreviewFolderUI.xrD.get(i2 - 1);
            }
            bVar2.convertView.setOnClickListener(this);
            bVar2.convertView.setTag(albumItem);
            if (SelectAlbumPreviewFolderUI.this.xrH == null || (!SelectAlbumPreviewFolderUI.this.xrH.equals(albumItem.albumName) && (!SelectAlbumPreviewFolderUI.this.xrH.equals(SelectAlbumPreviewFolderUI.d(SelectAlbumPreviewFolderUI.this)) || i2 != 0))) {
                bVar2.xps.setVisibility(4);
            } else {
                bVar2.xps.setVisibility(0);
            }
            if (i2 == 0) {
                bVar2.xdY.setImageResource(R.drawable.ckb);
                if (albumItem.UXc != null) {
                    h.a(bVar2.xdY, albumItem.dRj(), albumItem.aQn(), albumItem.dRh(), albumItem.dRi(), i2, albumItem.hVP());
                }
                bVar2.jBR.setText(SelectAlbumPreviewFolderUI.d(SelectAlbumPreviewFolderUI.this));
                bVar2.xdY.setVisibility(0);
                bVar2.jBR.setVisibility(0);
                bVar2.xpr.setVisibility(8);
                AppMethodBeat.o(111662);
                return;
            }
            bVar2.xdY.setVisibility(0);
            bVar2.jBR.setVisibility(0);
            bVar2.jBR.setText(albumItem.albumName);
            bVar2.xpr.setVisibility(0);
            bVar2.xpr.setText(this.mContext.getString(R.string.dm3, String.valueOf(albumItem.dJl)));
            if (!(bVar2.tlC == null || albumItem.UXc == null)) {
                bVar2.tlC.setVisibility(albumItem.UXc.getType() == 2 ? 0 : 8);
            }
            String aQn = albumItem.aQn();
            if (!Util.isNullOrNil(aQn) && albumItem.UXc != null) {
                h.a(bVar2.xdY, albumItem.dRj(), aQn, albumItem.dRh(), albumItem.dRi(), i2, albumItem.hVP());
                AppMethodBeat.o(111662);
            } else if (albumItem.UXc == null || albumItem.UXc.getType() != 2) {
                Log.e("MicroMsg.SelectAlbumPreviewFolderUI", "get folder failed");
                bVar2.xdY.setVisibility(8);
                bVar2.jBR.setVisibility(8);
                AppMethodBeat.o(111662);
            } else {
                h.a(bVar2.xdY, albumItem.dRj(), (String) null, albumItem.dRh(), albumItem.dRi(), i2, albumItem.hVP());
                AppMethodBeat.o(111662);
            }
        }

        public a(Context context) {
            this.mContext = context;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(111660);
            int size = SelectAlbumPreviewFolderUI.this.xrD.size() + 1;
            AppMethodBeat.o(111660);
            return size;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(111661);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SelectAlbumPreviewFolderUI$SelectImageFolderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(SelectAlbumPreviewFolderUI.this, AlbumPreviewUI.class);
            intent.putExtra("select_folder_name", (GalleryItem.AlbumItem) view.getTag());
            intent.setFlags(67108864);
            SelectAlbumPreviewFolderUI.this.setResult(-1, intent);
            SelectAlbumPreviewFolderUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SelectAlbumPreviewFolderUI$SelectImageFolderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111661);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(111663);
            b bVar = new b(LayoutInflater.from(this.mContext).inflate(R.layout.bol, viewGroup, false));
            AppMethodBeat.o(111663);
            return bVar;
        }
    }

    class b extends RecyclerView.v {
        public View convertView;
        public TextView jBR = ((TextView) this.convertView.findViewById(R.id.d7p));
        public ImageView tlC = ((ImageView) this.convertView.findViewById(R.id.j5b));
        public ImageView xdY = ((ImageView) this.convertView.findViewById(R.id.d7u));
        public TextView xpr = ((TextView) this.convertView.findViewById(R.id.d7l));
        public ImageView xps = ((ImageView) this.convertView.findViewById(R.id.d7t));

        public b(View view) {
            super(view);
            AppMethodBeat.i(111664);
            this.convertView = view;
            AppMethodBeat.o(111664);
        }
    }

    static /* synthetic */ String d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        AppMethodBeat.i(111670);
        if (e.dQK().xjo == 1) {
            String string = selectAlbumPreviewFolderUI.getString(R.string.dlh);
            AppMethodBeat.o(111670);
            return string;
        } else if (e.dQK().xjo == 3) {
            String string2 = selectAlbumPreviewFolderUI.getString(R.string.dli);
            AppMethodBeat.o(111670);
            return string2;
        } else {
            String string3 = selectAlbumPreviewFolderUI.getString(R.string.dlj);
            AppMethodBeat.o(111670);
            return string3;
        }
    }
}
