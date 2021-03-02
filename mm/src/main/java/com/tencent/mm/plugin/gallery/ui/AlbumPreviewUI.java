package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.gallery.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView;
import com.tencent.mm.plugin.gallery.ui.VLogPreloadUI;
import com.tencent.mm.plugin.gallery.ui.a;
import com.tencent.mm.plugin.gallery.ui.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI extends MMActivity implements i.c {
    static long start = 0;
    protected String dRL;
    private int gsi;
    private ProgressDialog gtM;
    protected int het;
    private List<Long> idList = new ArrayList();
    private int jVX = 3;
    private boolean krh = false;
    protected int kyt;
    private double latitude;
    private double longitude;
    private int oEo = -1;
    private boolean qUd = true;
    public boolean qoL = false;
    protected String toUser;
    protected int wnd;
    protected RecyclerView xnM;
    private TextView xnN;
    private boolean xnO;
    private boolean xnP;
    protected a xnQ;
    private TextView xnR;
    private TextView xnS;
    private TextView xnT;
    private ImageFolderMgrView xnU;
    private TextView xnV;
    private ImageButton xnW;
    private String xnX;
    private String xnY;
    private String xnZ;
    protected String xnr;
    private a.f xnw = new a.f() {
        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.gallery.ui.a.f
        public final void a(int i2, View view, int i3) {
            AppMethodBeat.i(179458);
            switch (i3) {
                case 0:
                    AlbumPreviewUI.D(AlbumPreviewUI.this);
                    AppMethodBeat.o(179458);
                    return;
                case 1:
                    AlbumPreviewUI.this.g(i2, view);
                    break;
            }
            AppMethodBeat.o(179458);
        }
    };
    private HashMap<String, Integer> xoA = new HashMap<>();
    private HashSet<String> xoB;
    boolean xoC;
    private p.c xoD = p.c.IDLE;
    private int xoE = -1;
    private String xoF = "";
    private boolean xoa;
    private boolean xob = false;
    private boolean xoc;
    private boolean xod;
    private boolean xoe;
    private boolean xof;
    private boolean xog = false;
    private boolean xoh = false;
    boolean xoi = false;
    private int xoj = 0;
    private int xok = 0;
    private long xol = 0;
    private long xom;
    private int xon = -1;
    protected int xoo;
    private String xop;
    private i.b xoq;
    private boolean xor;
    protected int xos;
    private boolean xot;
    private e xou;
    private volatile long xov = -1;
    protected MenuItem.OnMenuItemClickListener xow = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass12 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(164796);
            int itemId = menuItem.getItemId();
            Log.d("MicroMsg.AlbumPreviewUI", "mId: %d.", Integer.valueOf(itemId));
            if (1 == itemId) {
                Log.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
                a.C1384a.xhE.xhr = 1;
                s.dRv().eW(AlbumPreviewUI.this.xnQ.xnp);
                Intent intent = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
                intent.putExtra("select_type_tag", 2);
                intent.putExtras(AlbumPreviewUI.this.getIntent());
                intent.putExtra("send_raw_img", AlbumPreviewUI.this.qoL);
                AlbumPreviewUI.this.startActivityForResult(intent, 4382);
                AppMethodBeat.o(164796);
                return true;
            }
            boolean dyR = AlbumPreviewUI.this.dyR();
            AppMethodBeat.o(164796);
            return dyR;
        }
    };
    private GalleryItem.AlbumItem xox;
    private a.d xoy;
    private volatile b xoz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AlbumPreviewUI() {
        AppMethodBeat.i(111463);
        AppMethodBeat.o(111463);
    }

    static /* synthetic */ int C(AlbumPreviewUI albumPreviewUI) {
        int i2 = albumPreviewUI.xok + 1;
        albumPreviewUI.xok = i2;
        return i2;
    }

    static /* synthetic */ void b(AlbumPreviewUI albumPreviewUI, GalleryItem.AlbumItem albumItem) {
        AppMethodBeat.i(257742);
        albumPreviewUI.b(albumItem);
        AppMethodBeat.o(257742);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111464);
        super.onCreate(bundle);
        Log.i("MicroMsg.AlbumPreviewUI", "onCreate, %s.", this);
        setRequestedOrientation(1);
        this.xot = com.tencent.mm.pluginsdk.permission.b.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 145, getString(R.string.flp), getString(R.string.dlz));
        Log.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", Boolean.valueOf(this.xot));
        this.xom = System.currentTimeMillis();
        start = System.currentTimeMillis();
        this.gtM = q.b(this, getString(R.string.a06), false, 0, null);
        this.xoz = b.CREATE;
        if (bundle != null) {
            Log.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.het = bundle.getInt("constants_key_query_source");
            this.xos = bundle.getInt("constants_key_query_type");
        } else {
            this.het = getIntent().getIntExtra("query_source_type", 3);
            this.xos = getIntent().getIntExtra("query_media_type", 1);
        }
        com.tencent.mm.plugin.gallery.model.e.dQK().mcq = this.het;
        com.tencent.mm.plugin.gallery.model.e.dQK().setQueryType(this.xos);
        Log.i("MicroMsg.AlbumPreviewUI", "query source: " + this.het + ", queryType: " + this.xos);
        this.jVX = getIntent().getIntExtra("select_type_tag", 3);
        this.qUd = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true);
        this.xor = getIntent().getBooleanExtra("is_from_smart_gallery", false);
        initView();
        if (this.xot) {
            dRV();
        }
        com.tencent.mm.plugin.gallery.model.e.dQS();
        AppMethodBeat.o(111464);
    }

    private void dRU() {
        AppMethodBeat.i(173771);
        com.tencent.mm.plugin.gallery.model.g dQL = com.tencent.mm.plugin.gallery.model.e.dQL();
        a aVar = new a(this);
        MMHandler dRf = dQL.dRf();
        if (dRf != null) {
            dRf.post(aVar);
            AppMethodBeat.o(173771);
            return;
        }
        Log.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
        AppMethodBeat.o(173771);
    }

    private void dRV() {
        AppMethodBeat.i(173772);
        if (this.xor) {
            this.xnQ.eX(s.dRv().xjH);
            com.tencent.mm.plugin.gallery.model.e.dQP().addAll(this.xnQ.xnp);
            NM(this.xnQ.xnp.size());
            ayY(getIntent().getStringExtra("album_id_from_smart_gallery"));
            this.gtM.show();
            AppMethodBeat.o(173772);
            return;
        }
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
        if (getIntent().hasExtra("gallery_report_tag")) {
            a.C1384a.xhE.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
        } else {
            a.C1384a.xhE.setScene(this.het);
        }
        Log.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", this);
        com.tencent.mm.plugin.gallery.model.e.dQK().a(this);
        this.xov = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.e.dQK().ax(this.xnY, this.xov);
        getContentView().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(111422);
                Log.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
                if (b.SKIP != AlbumPreviewUI.this.xoz) {
                    AlbumPreviewUI.this.gtM.show();
                }
                AppMethodBeat.o(111422);
            }
        }, 300);
        p.a aVar = p.xjw;
        p.dRt().a(new l());
        p.a aVar2 = p.xjw;
        p.dRt().a(new com.tencent.mm.plugin.gallery.model.q());
        AppMethodBeat.o(173772);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111465);
        super.onResume();
        Log.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", this);
        f.e(true, true, true);
        this.xoh = false;
        AppMethodBeat.o(111465);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(111466);
        super.onStart();
        Log.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", this);
        if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != this.het) {
            com.tencent.mm.plugin.gallery.model.e.dQK().mcq = this.het;
        }
        if (com.tencent.mm.plugin.gallery.model.e.dQK().xjo != this.xos) {
            com.tencent.mm.plugin.gallery.model.e.dQK().setQueryType(this.xos);
        }
        AppMethodBeat.o(111466);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(111467);
        super.onPause();
        Log.i("MicroMsg.AlbumPreviewUI", "on onPause, %s.", this);
        f.e(false, true, true);
        this.xoh = true;
        if (!isFinishing() && !isDestroyed() && this.xnU != null && this.xnU.jT) {
            ImageFolderMgrView imageFolderMgrView = this.xnU;
            if (!imageFolderMgrView.jT) {
                Log.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.xpW) {
                Log.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.xpS.setVisibility(8);
                imageFolderMgrView.jT = false;
                if (imageFolderMgrView.xqa != null) {
                    imageFolderMgrView.xqa.pB(false);
                }
            }
        }
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.gsi);
        this.gsi = 0;
        if (this.xor) {
            s.dRv().eW(this.xnQ.xnp);
        }
        AppMethodBeat.o(111467);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(111468);
        super.onStop();
        Log.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", this);
        if (!this.xor) {
            com.tencent.mm.plugin.gallery.model.c dQJ = com.tencent.mm.plugin.gallery.model.e.dQJ();
            if (dQJ.xhQ != null && !dQJ.xhQ.isEmpty()) {
                for (Map.Entry<String, c.C1385c> entry : dQJ.xhQ.entrySet()) {
                    c.C1385c value = entry.getValue();
                    if (value != null) {
                        value.mCancel = true;
                    }
                }
                if (dQJ.xhP != null) {
                    dQJ.xhP.clear();
                }
                if (dQJ.xhQ != null && !dQJ.xhQ.isEmpty()) {
                    dQJ.xhQ.clear();
                }
                dQJ.xhN.dQF();
            }
            com.tencent.mm.plugin.gallery.model.e.dQJ().dQE();
        }
        AppMethodBeat.o(111468);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        boolean z = false;
        AppMethodBeat.i(111469);
        super.onDestroy();
        Log.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", this);
        if (com.tencent.mm.plugin.gallery.model.e.dQK() != null) {
            com.tencent.mm.plugin.gallery.model.e.dQK().b(this);
            o dQK = com.tencent.mm.plugin.gallery.model.e.dQK();
            i.b bVar = this.xoq;
            if (bVar != null) {
                dQK.xjm.remove(bVar);
            }
        }
        if (this.xoj > 0 || this.xok > 0) {
            Log.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", Integer.valueOf(this.xoj), Integer.valueOf(this.xok));
            com.tencent.mm.plugin.gallery.a.d.bw(11187, this.xoj + "," + this.xok);
        } else {
            Log.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
        }
        if (this.xol > 0 || this.xnP) {
            com.tencent.mm.plugin.gallery.model.e.a(this.xnZ, ar(this.xnQ.xnp), this.qoL, this.xnO);
        }
        int size = this.xnQ.xnp.size();
        boolean z2 = this.qoL;
        if (this.xol > 0 || this.xnP) {
            z = true;
        }
        com.tencent.mm.plugin.gallery.model.e.g(size, z2, z);
        ab.diQ.Uo().Un();
        com.tencent.mm.plugin.gallery.model.e.dQN().clear();
        com.tencent.mm.plugin.gallery.model.e.dQO().clear();
        com.tencent.mm.plugin.gallery.model.e.dQP().clear();
        if (this.xor) {
            s.dRv().xjF = true;
        } else {
            if (!this.krh) {
                a.C1384a.xhE.report();
            } else {
                a.C1384a.xhE.reset();
            }
            s.dRv().xjG = true;
            com.tencent.mm.plugin.gallery.model.e.dQK().dRs();
        }
        if (com.tencent.mm.plugin.gallery.model.e.dQT()) {
            com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).axJ();
            a.g.dRR();
        }
        AppMethodBeat.o(111469);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(111470);
        super.onSaveInstanceState(bundle);
        Log.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", this);
        bundle.putInt("constants_key_query_source", this.het);
        bundle.putInt("constants_key_query_type", this.xos);
        AppMethodBeat.o(111470);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.boj;
    }

    private static int[] ar(ArrayList<GalleryItem.MediaItem> arrayList) {
        AppMethodBeat.i(111471);
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator<GalleryItem.MediaItem> it = arrayList.iterator();
        while (it.hasNext()) {
            GalleryItem.MediaItem next = it.next();
            if (next != null) {
                if (!Util.isNullOrNil(next.mMimeType) && next.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (next.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (next.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        AppMethodBeat.o(111471);
        return iArr;
    }

    private void b(GalleryItem.AlbumItem albumItem) {
        AppMethodBeat.i(111472);
        if (albumItem == null) {
            AppMethodBeat.o(111472);
            return;
        }
        if (albumItem.UXd) {
            this.jVX = 3;
        } else {
            this.jVX = 4;
        }
        if (Util.nullAs(this.xnY, "").equals(albumItem.albumName)) {
            Log.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
            AppMethodBeat.o(111472);
            return;
        }
        com.tencent.mm.plugin.gallery.model.e.dQP().addAll(this.xnQ.xnp);
        Log.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", albumItem.albumName, albumItem.aQn());
        this.xnX = albumItem.aQn();
        this.xnY = albumItem.albumName;
        if (Util.isNullOrNil(this.xnX)) {
            Log.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
            this.xnX = this.xnY;
        }
        if (!Util.isNullOrNil(this.xnY)) {
            a aVar = this.xnQ;
            a.d dVar = this.xoy;
            if (dVar == null) {
                Log.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
            } else {
                aVar.xns.remove(dVar);
            }
        } else if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.xnQ.a(this.xoy);
        }
        String str = albumItem.nickName;
        if (Util.isNullOrNil(str)) {
            if (this.xos == 3) {
                str = getString(R.string.dli);
            } else if (this.xos == 1) {
                str = getString(R.string.dlh);
            } else {
                str = getString(R.string.dlj);
            }
        }
        updateActionBarOperationAreaTxt(str);
        NM(this.xnQ.xnp.size());
        this.gtM.show();
        start = System.currentTimeMillis();
        String str2 = this.xnY;
        int i2 = this.xos;
        if (str2.equals(getString(R.string.dlj))) {
            str2 = "";
            i2 = 2;
        }
        if (this.xnY.equalsIgnoreCase(getString(R.string.dlp))) {
            if (this.xou != null) {
                this.xou.xph = false;
            }
            com.tencent.mm.plugin.gallery.model.e.dQL().as(this.xou);
        } else if (albumItem instanceof GalleryItem.PrivateAlbumItem) {
            com.tencent.mm.plugin.gallery.model.e.dQK().dRs();
            this.xov = System.currentTimeMillis();
            s.dRv().xjF = true;
            String str3 = ((GalleryItem.PrivateAlbumItem) albumItem).xjf.xjJ;
            if (Util.isNullOrNil(str3)) {
                Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
            } else {
                com.tencent.mm.plugin.gallery.model.e.dQL().as(new d(str3, this.xnQ, this.gtM, this.xnM));
            }
        } else {
            if (this.xou != null) {
                this.xou.xph = true;
            }
            s.dRv().xjG = true;
            s.dRv().xjF = true;
            this.xov = System.currentTimeMillis();
            com.tencent.mm.plugin.gallery.model.e.dQK().D(str2, i2, this.xov);
        }
        String str4 = "public";
        if (albumItem instanceof GalleryItem.PrivateAlbumItem) {
            str4 = "private";
        }
        try {
            h.INSTANCE.a(18269, URLEncoder.encode(str4, ProtocolPackage.ServerEncoding), URLEncoder.encode(albumItem.nickName, ProtocolPackage.ServerEncoding));
            AppMethodBeat.o(111472);
        } catch (Exception e2) {
            AppMethodBeat.o(111472);
        }
    }

    public final void az(int i2, boolean z) {
        AppMethodBeat.i(111473);
        switch (this.xos) {
            case 3:
                if (!Util.isNullOrNil(this.dRL) && !"medianote".equals(this.toUser)) {
                    if (Util.currentTicks() - this.xol >= 1000) {
                        Log.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
                        GalleryItem.MediaItem mediaItem = this.xnQ.xno.get(i2);
                        if (mediaItem.getType() != 2) {
                            try {
                                com.tencent.mm.plugin.gallery.a.d.c(mediaItem.xiW, this.toUser, this.xob || !this.qoL, z);
                                AppMethodBeat.o(111473);
                                return;
                            } catch (Exception e2) {
                                break;
                            }
                        }
                    } else {
                        Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
                        AppMethodBeat.o(111473);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(111473);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        int i2;
        AppMethodBeat.i(111474);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                Log.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", str, extras.get(str));
            }
        } else {
            Log.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
        }
        this.xnr = getIntent().getStringExtra("album_business_tag");
        this.kyt = getIntent().getIntExtra("album_video_max_duration", 10);
        this.xoo = getIntent().getIntExtra("album_video_min_duration", 0);
        this.dRL = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.wnd = getIntent().getIntExtra("max_select_count", 9);
        this.xob = this.het == 4;
        this.xnX = getIntent().getStringExtra("folder_path");
        this.xnY = getIntent().getStringExtra("folder_name");
        if (Util.isNullOrNil(this.xnX)) {
            Log.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", this.xnY);
            this.xnX = this.xnY;
        }
        this.qoL = getIntent().getBooleanExtra("key_send_raw_image", false) || getIntent().getBooleanExtra("send_raw_img", false);
        this.xoc = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
        this.xod = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
        this.xoe = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
        this.xof = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
        this.xog = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.xnV = (TextView) findViewById(R.id.g6p);
        this.xnW = (ImageButton) findViewById(R.id.g6o);
        this.xnV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(111434);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AlbumPreviewUI.this.xnW.performClick();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111434);
            }
        });
        if (this.het == 3 || this.xoe) {
            this.xnW.setVisibility(0);
            this.xnV.setVisibility(0);
        } else {
            this.xnW.setVisibility(8);
            this.xnV.setVisibility(8);
        }
        if (this.qoL) {
            this.xnW.setImageResource(R.raw.radio_on);
        } else {
            this.xnW.setImageResource(R.raw.radio_off);
        }
        if (this.xof) {
            this.xnW.setImageResource(R.raw.radio_default_on);
        }
        this.xnW.setEnabled(!this.xof);
        this.xnV.setEnabled(!this.xof);
        this.xnW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(111435);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AlbumPreviewUI.this.qoL = !AlbumPreviewUI.this.qoL;
                AlbumPreviewUI.d(AlbumPreviewUI.this);
                AlbumPreviewUI.this.xnV.setText(AlbumPreviewUI.this.getContext().getString(R.string.dm8).concat(AlbumPreviewUI.dRZ()));
                if (AlbumPreviewUI.this.qoL) {
                    AlbumPreviewUI.this.xnW.setImageResource(R.raw.radio_on);
                } else {
                    AlbumPreviewUI.this.xnW.setImageResource(R.raw.radio_off);
                }
                AlbumPreviewUI.f(AlbumPreviewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111435);
            }
        });
        this.xnM = (RecyclerView) findViewById(R.id.fbp);
        this.xnR = (TextView) findViewById(R.id.lb);
        this.xnS = (TextView) findViewById(R.id.lc);
        this.xnT = (TextView) findViewById(R.id.kl);
        this.xnN = (TextView) findViewById(R.id.fby);
        boolean z2 = 1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_smart_gallery_switch, 0);
        Log.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", Boolean.valueOf(z2));
        if (!z2) {
            z = false;
        } else {
            String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_smart_gallery_black_list, "");
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            String lowerCase2 = Build.MODEL.toLowerCase();
            Log.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", lowerCase, lowerCase2, a2);
            z = !a2.contains(lowerCase) && !a2.contains(lowerCase2);
        }
        Log.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", Boolean.valueOf(this.xor), Boolean.valueOf(z));
        if (!this.xor && (z || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE)) {
            addTextOptionMenu(1, null, this.xow, null, t.b.SMART_GALLERY_SEARCH_ENTRY);
            if (this.xot) {
                dRU();
            }
        }
        if (this.het == 0 || this.het == 5 || this.het == 10 || this.het == 11 || this.het == 24 || this.het == 27) {
            findViewById(R.id.jt).setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.xnM.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.xnM.setLayoutParams(layoutParams);
        } else {
            this.xnN.setVisibility(0);
            this.xnN.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass17 */

                public final void onClick(View view) {
                    AppMethodBeat.i(164797);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    AlbumPreviewUI.this.xnO = true;
                    Intent intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                    com.tencent.mm.plugin.gallery.model.e.ao(AlbumPreviewUI.this.xnQ.xno);
                    intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.xnQ.dRL());
                    intent.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.xnQ.xnp);
                    intent.putExtra("max_select_count", AlbumPreviewUI.this.wnd);
                    intent.putExtra("send_raw_img", AlbumPreviewUI.this.qoL);
                    intent.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.this.xoc);
                    intent.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.this.xoe);
                    intent.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.this.xof);
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.dRL);
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                    intent.putExtra("select_type_tag", AlbumPreviewUI.this.jVX);
                    intent.putExtra("album_business_tag", AlbumPreviewUI.this.xnr);
                    intent.putExtra("album_video_max_duration", AlbumPreviewUI.this.kyt);
                    intent.putExtra("album_video_min_duration", AlbumPreviewUI.this.xoo);
                    AlbumPreviewUI.this.startActivityForResult(intent, 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(164797);
                }
            });
            if ((this.xos == 1 || this.xos == 2 || this.xos == 3) && this.wnd > 0) {
                if (!Util.isNullOrNil(this.xnZ)) {
                    addTextOptionMenu(0, this.xnZ, this.xow);
                } else {
                    String a3 = com.tencent.mm.plugin.gallery.a.d.a(this, this.het, 0, this.wnd, this.xnr, this.xnQ == null ? null : this.xnQ.xnp);
                    if (this.het == 15) {
                        addTextOptionMenu(0, a3, this.xow, null, t.b.YELLOW);
                    } else {
                        addTextOptionMenu(0, a3, this.xow, null, t.b.DARK_GREEN_MODE);
                    }
                }
            }
        }
        this.xnU = (ImageFolderMgrView) findViewById(R.id.dvk);
        this.xnU.setListener(new ImageFolderMgrView.a() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.a
            public final void c(GalleryItem.AlbumItem albumItem) {
                AppMethodBeat.i(111437);
                AlbumPreviewUI.this.xox = albumItem;
                AppMethodBeat.o(111437);
            }
        });
        this.xnU.setOnFolderStateChanged(new ImageFolderMgrView.b() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass19 */

            @Override // com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.b
            public final void pB(boolean z) {
                AppMethodBeat.i(111438);
                if (!z) {
                    if (AlbumPreviewUI.this.xoC && !AlbumPreviewUI.this.xnU.getSelectedAlbumName().equalsIgnoreCase(AlbumPreviewUI.this.getString(R.string.dlp))) {
                        AlbumPreviewUI.this.setSmartGalleryEntryVisibility(true);
                    }
                    if (AlbumPreviewUI.this.xox != null) {
                        if (!Util.nullAs(AlbumPreviewUI.this.xnY, "").equals(AlbumPreviewUI.this.xox.albumName)) {
                            AlbumPreviewUI.b(AlbumPreviewUI.this, AlbumPreviewUI.this.xox);
                            AppMethodBeat.o(111438);
                            return;
                        }
                        AlbumPreviewUI.this.playActionBarOperationAreaAnim();
                    }
                } else if (AlbumPreviewUI.this.xoC) {
                    AlbumPreviewUI.this.setSmartGalleryEntryVisibility(false);
                    AppMethodBeat.o(111438);
                    return;
                }
                AppMethodBeat.o(111438);
            }
        });
        ImageFolderMgrView imageFolderMgrView = this.xnU;
        boolean z3 = this.xot;
        Log.i("MicroMsg.ImageFolderMgrView", "attach, %s.", imageFolderMgrView);
        com.tencent.mm.plugin.gallery.model.e.dQK().b(imageFolderMgrView);
        com.tencent.mm.plugin.gallery.model.e.dQK().a(imageFolderMgrView);
        com.tencent.mm.plugin.gallery.model.e.dQK().c(imageFolderMgrView.xpX);
        com.tencent.mm.plugin.gallery.model.e.dQK().xjk.add(imageFolderMgrView.xpX);
        if (z3) {
            com.tencent.mm.plugin.gallery.model.e.dQK().dRr();
        }
        this.xnZ = getIntent().getStringExtra("send_btn_string");
        this.xoa = getIntent().getBooleanExtra("is_hide_album_footer", false);
        if (this.xoa) {
            findViewById(R.id.jt).setVisibility(8);
        }
        enableOptionMenu(false);
        getContext();
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        this.xnM.setLayoutManager(gridLayoutManager);
        c.a dSd = new c.a(getContext()).NP(R.dimen.a8i).NO(R.dimen.a8i).dSd();
        dSd.xpw = false;
        this.xnM.a(dSd.dSf());
        this.xnM.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass20 */
            private Runnable qpo = new Runnable() {
                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass20.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(111440);
                    if (AlbumPreviewUI.this.xnR.getVisibility() == 0) {
                        AlbumPreviewUI.this.xnR.animate().alpha(0.0f).setDuration(300).withEndAction(new Runnable() {
                            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass20.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(111439);
                                AlbumPreviewUI.this.xnR.setVisibility(4);
                                AppMethodBeat.o(111439);
                            }
                        }).start();
                    }
                    AppMethodBeat.o(111440);
                }
            };

            {
                AppMethodBeat.i(111441);
                AppMethodBeat.o(111441);
            }

            private String dSc() {
                AppMethodBeat.i(111442);
                String NL = AlbumPreviewUI.this.xnQ.NL(gridLayoutManager.ks());
                if (Util.isNullOrNil(NL) || !NL.equals("album_business_bubble_media_by_coordinate")) {
                    AppMethodBeat.o(111442);
                    return NL;
                }
                String str = AlbumPreviewUI.this.xop + "附近的照片和视频";
                AppMethodBeat.o(111442);
                return str;
            }

            private void pC(boolean z) {
                AppMethodBeat.i(111443);
                if (z) {
                    AlbumPreviewUI.this.xnR.removeCallbacks(this.qpo);
                    if (AlbumPreviewUI.this.xnR.getVisibility() != 0) {
                        AlbumPreviewUI.this.xnR.setText(dSc());
                        AlbumPreviewUI.this.xnR.setVisibility(0);
                        AlbumPreviewUI.this.xnR.setAlpha(0.0f);
                        AlbumPreviewUI.this.xnR.animate().alpha(1.0f).setDuration(300).start();
                        AppMethodBeat.o(111443);
                        return;
                    }
                } else {
                    AlbumPreviewUI.this.xnR.removeCallbacks(this.qpo);
                    AlbumPreviewUI.this.xnR.postDelayed(this.qpo, 256);
                }
                AppMethodBeat.o(111443);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                int i3;
                AppMethodBeat.i(111444);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                Log.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", Integer.valueOf(i2));
                if (1 == i2) {
                    pC(true);
                    AlbumPreviewUI.this.xnS.setVisibility(8);
                    com.tencent.mm.plugin.gallery.model.e.dQJ().dQE();
                } else if (i2 == 0) {
                    pC(false);
                    AlbumPreviewUI.this.xoE = gridLayoutManager.ks();
                    AlbumPreviewUI.this.oEo = gridLayoutManager.ku();
                    Log.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", Integer.valueOf(AlbumPreviewUI.this.xoE), Integer.valueOf(AlbumPreviewUI.this.oEo));
                    p.a aVar = p.xjw;
                    p.dRt().a(p.c.IDLE, AlbumPreviewUI.this.xoE, AlbumPreviewUI.this.oEo, AlbumPreviewUI.this.xnQ.xno.size());
                } else if (2 == i2) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.this.gsi);
                    AlbumPreviewUI albumPreviewUI = AlbumPreviewUI.this;
                    boolean z = WXHardCoderJNI.hcAlbumScrollEnable;
                    int i4 = WXHardCoderJNI.hcAlbumScrollDelay;
                    int i5 = WXHardCoderJNI.hcAlbumScrollCPU;
                    int i6 = WXHardCoderJNI.hcAlbumScrollIO;
                    if (WXHardCoderJNI.hcAlbumScrollThr) {
                        i3 = Process.myTid();
                    } else {
                        i3 = 0;
                    }
                    albumPreviewUI.gsi = WXHardCoderJNI.startPerformance(z, i4, i5, i6, i3, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.AlbumPreviewUI");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(111444);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(111445);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                AlbumPreviewUI.this.xnR.setText(dSc());
                int ks = gridLayoutManager.ks();
                int ku = gridLayoutManager.ku();
                Log.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", Integer.valueOf(ks), Integer.valueOf(ku), Integer.valueOf(AlbumPreviewUI.this.xoE), Integer.valueOf(AlbumPreviewUI.this.oEo));
                if (!(AlbumPreviewUI.this.xoE == ks && AlbumPreviewUI.this.oEo == ku)) {
                    AlbumPreviewUI.this.xoE = ks;
                    AlbumPreviewUI.this.oEo = ku;
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = AlbumPreviewUI.this.xoE; i4 <= AlbumPreviewUI.this.oEo; i4++) {
                        GalleryItem.MediaItem NK = AlbumPreviewUI.this.xnQ.NK(i4);
                        if (NK != null) {
                            arrayList.add(com.tencent.mm.plugin.gallery.a.d.a(NK.aQn(), (s.e) null, -1));
                        }
                    }
                    Log.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", Integer.valueOf(arrayList.size()));
                    com.tencent.mm.plugin.gallery.model.e.dQJ().eT(arrayList);
                    if (i3 != 0) {
                        if (i3 < 0) {
                            AlbumPreviewUI.this.xoD = p.c.UP;
                        } else {
                            AlbumPreviewUI.this.xoD = p.c.DOWN;
                        }
                        Log.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", Integer.valueOf(i3), AlbumPreviewUI.this.xoD);
                        p.a aVar = p.xjw;
                        p.dRt().a(AlbumPreviewUI.this.xoD, AlbumPreviewUI.this.xoE, AlbumPreviewUI.this.oEo, AlbumPreviewUI.this.xnQ.xno.size());
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(111445);
            }
        });
        this.xnQ = new a(getContext(), new a.e() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass21 */

            @Override // com.tencent.mm.plugin.gallery.ui.a.e
            public final void ah(int i2, int i3, int i4) {
                AppMethodBeat.i(111446);
                GalleryItem.MediaItem NK = AlbumPreviewUI.this.xnQ.NK(i3);
                if (NK == null) {
                    AppMethodBeat.o(111446);
                    return;
                }
                if (i4 != 0) {
                    a.C1384a.xhE.al(NK.xiW, AlbumPreviewUI.this.jVX, i3);
                    AlbumPreviewUI.this.NM(i2);
                    AlbumPreviewUI.this.az(i3, false);
                } else if (NK.getType() == 1) {
                    if (!AlbumPreviewUI.this.a(NK)) {
                        AlbumPreviewUI.this.xnQ.i(NK);
                    } else {
                        a.C1384a.xhE.al(NK.xiW, AlbumPreviewUI.this.jVX, i3);
                        AlbumPreviewUI.a(AlbumPreviewUI.this, NK);
                        AlbumPreviewUI.this.NM(i2);
                        AlbumPreviewUI.this.az(i3, true);
                    }
                } else if (NK.getType() != 2) {
                    a.C1384a.xhE.al(NK.xiW, AlbumPreviewUI.this.jVX, i3);
                    AlbumPreviewUI.this.NM(i2);
                    AlbumPreviewUI.this.az(i3, true);
                } else if (!AlbumPreviewUI.this.b(NK)) {
                    AlbumPreviewUI.this.xnQ.i(NK);
                } else {
                    a.C1384a.xhE.al(NK.xiW, AlbumPreviewUI.this.jVX, i3);
                    AlbumPreviewUI.this.NM(i2);
                    AlbumPreviewUI.this.az(i3, true);
                }
                if (Util.isNullOrNil(AlbumPreviewUI.this.xnQ.dRL())) {
                    AppMethodBeat.o(111446);
                    return;
                }
                Iterator<String> it = AlbumPreviewUI.this.xnQ.dRL().iterator();
                while (it.hasNext()) {
                    if (!ImgUtil.isGif(it.next())) {
                        AppMethodBeat.o(111446);
                        return;
                    }
                }
                AlbumPreviewUI.this.qoL = true;
                AppMethodBeat.o(111446);
            }
        });
        this.xnQ.xnw = this.xnw;
        if (!Util.isNullOrNil(this.xnr)) {
            Log.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", this.xnr);
            this.xnQ.xnr = this.xnr;
            this.xnQ.kyt = this.kyt;
            if (this.xnr.equals("album_business_bubble_media_by_coordinate")) {
                this.xnQ.xnt = false;
                com.tencent.mm.plugin.gallery.model.e.dQK().xjn.dQw();
                this.xop = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
                final double doubleExtra = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0d);
                this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0d);
                this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0d);
                if (doubleExtra >= 0.0d && com.tencent.mm.modelgeo.a.m(this.longitude) && com.tencent.mm.modelgeo.a.n(this.latitude)) {
                    this.xoq = new i.b() {
                        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.gallery.model.i.b
                        public final void c(LinkedList<GalleryItem.MediaItem> linkedList, long j2) {
                            AppMethodBeat.i(111423);
                            Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                            if (j2 != AlbumPreviewUI.this.xov) {
                                Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j2), Long.valueOf(AlbumPreviewUI.this.xov));
                                Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                                AppMethodBeat.o(111423);
                            } else if (linkedList == null || linkedList.isEmpty()) {
                                Log.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
                                AppMethodBeat.o(111423);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                Iterator<GalleryItem.MediaItem> it = linkedList.iterator();
                                while (it.hasNext()) {
                                    GalleryItem.MediaItem next = it.next();
                                    if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.this.latitude, AlbumPreviewUI.this.longitude, next.cik, next.cil) <= doubleExtra) {
                                        next.xjc = "album_business_bubble_media_by_coordinate";
                                        arrayList.add(next);
                                    }
                                }
                                linkedList.removeAll(arrayList);
                                Log.d("MicroMsg.AlbumPreviewUI", "target media size=%d", Integer.valueOf(arrayList.size()));
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    Log.d("MicroMsg.AlbumPreviewUI", "target media item=%s", ((GalleryItem.MediaItem) it2.next()).toString());
                                }
                                if (!linkedList.isEmpty() && !arrayList.isEmpty()) {
                                    linkedList.addAll(0, arrayList);
                                }
                                AppMethodBeat.o(111423);
                            }
                        }
                    };
                    o dQK = com.tencent.mm.plugin.gallery.model.e.dQK();
                    i.b bVar = this.xoq;
                    if (bVar != null) {
                        dQK.xjm.add(bVar);
                    }
                }
            }
        }
        if (this.xog) {
            this.xnQ.xnt = true;
        }
        this.xoy = new a.b();
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.xnQ.a(this.xoy);
        }
        this.xnQ.xjo = this.xos;
        this.xnQ.xnn = this.wnd;
        Log.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.wnd);
        this.xnM.setAdapter(this.xnQ);
        if (this.xor) {
            setActionbarColor(getResources().getColor(R.color.s0));
            setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
        } else {
            setActionbarColor(getResources().getColor(R.color.s0));
            initActionBarOperationArea();
            if (this.xos == 3) {
                initActionBarOperationAreaTxt(getString(R.string.dli));
            } else if (this.xos == 1) {
                initActionBarOperationAreaTxt(getString(R.string.dlh));
            } else {
                initActionBarOperationAreaTxt(getString(R.string.dlj));
            }
        }
        setNavigationbarColor(getResources().getColor(R.color.s0));
        setActionBarOperationAreaClickListener(new AlbumChooserView.a() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.widget.AlbumChooserView.a
            public final void dSb() {
                AppMethodBeat.i(179457);
                Log.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
                AlbumPreviewUI.this.xox = null;
                a.C1384a.xhE.xhs = 1;
                Log.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", Integer.valueOf(AlbumPreviewUI.this.xok));
                AlbumPreviewUI.C(AlbumPreviewUI.this);
                AlbumPreviewUI.this.playActionBarOperationAreaAnim();
                AlbumPreviewUI.this.xnU.dSg();
                AppMethodBeat.o(179457);
            }
        });
        if (this.xor) {
            i2 = R.drawable.b2;
        } else {
            i2 = R.raw.actionbar_icon_close_black;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111424);
                Log.i("MicroMsg.AlbumPreviewUI", "backBtn");
                AlbumPreviewUI.this.onBackBtnClick();
                AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.qoL));
                if (AlbumPreviewUI.this.xnU == null || !AlbumPreviewUI.this.xnU.jT) {
                    AlbumPreviewUI.this.krh = true;
                    AlbumPreviewUI.this.finish();
                    AppMethodBeat.o(111424);
                } else {
                    AlbumPreviewUI.this.xnU.dSg();
                    AlbumPreviewUI.this.playActionBarOperationAreaAnim();
                    AppMethodBeat.o(111424);
                }
                return true;
            }
        }, i2);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.h8v);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).setListener(new DrawedCallBackFrameLayout.a() {
                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a
                public final void dSa() {
                    AppMethodBeat.i(111425);
                    com.tencent.mm.plugin.gallery.a.d.dSa();
                    if (AlbumPreviewUI.this.xoi) {
                        AlbumPreviewUI.this.xoi = false;
                    }
                    AppMethodBeat.o(111425);
                }
            });
        }
        this.xou = new e((byte) 0);
        this.xou.xoS = new WeakReference<>(this.xnQ);
        this.xou.xoT = new WeakReference<>(this.gtM);
        this.xou.xoX = new WeakReference<>(this.xnU);
        this.xou.idList = this.idList;
        this.xou.type = this.xos;
        AppMethodBeat.o(111474);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(164799);
        super.onBackPressed();
        onBackBtnClick();
        AppMethodBeat.o(164799);
    }

    /* access modifiers changed from: protected */
    public void onBackBtnClick() {
    }

    /* access modifiers changed from: protected */
    public boolean dyR() {
        int i2;
        int dSv;
        int i3 = 0;
        AppMethodBeat.i(111475);
        Log.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.dQR()), Boolean.valueOf(this.xob));
        com.tencent.mm.plugin.gallery.a.d.bw(11610, (this.xob ? 3 : 2) + "," + com.tencent.mm.plugin.gallery.model.e.dQR());
        if (this.xon < 0) {
            this.xon = com.tencent.mm.plugin.gallery.a.d.aqq();
        }
        com.tencent.mm.plugin.gallery.model.e.dQQ();
        if (this.xnQ.dRL().size() == 0) {
            Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
            setResult(-2);
            finish();
            AppMethodBeat.o(111475);
        } else {
            Intent intent = new Intent();
            int i4 = this.xos;
            if (this.xog) {
                if (this.xog && this.het == 16) {
                    Iterator<GalleryItem.MediaItem> it = this.xnQ.xnp.iterator();
                    if (it.hasNext()) {
                        GalleryItem.MediaItem next = it.next();
                        if (next.getType() == 1) {
                            i4 = 1;
                        } else if (next.getType() == 2) {
                            i4 = 2;
                        }
                    }
                }
                i4 = 1;
            }
            if (22 == com.tencent.mm.plugin.gallery.model.e.dQK().mcq) {
                ArrayList<GalleryItem.MediaItem> arrayList = this.xnQ.xnp;
                ArrayList<String> arrayList2 = new ArrayList<>();
                ArrayList<String> arrayList3 = new ArrayList<>();
                int[] iArr = new int[this.wnd];
                Iterator<GalleryItem.MediaItem> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    GalleryItem.MediaItem next2 = it2.next();
                    if (next2.getType() == 1) {
                        if (!next2.mMimeType.equals("edit") || Util.isNullOrNil(next2.xiY)) {
                            arrayList2.add(next2.xiW);
                        } else {
                            arrayList2.add(next2.xiY);
                        }
                        iArr[i3] = 1;
                        i3++;
                    } else if (next2.getType() == 2) {
                        arrayList3.add(next2.xiW);
                        iArr[i3] = 2;
                        i3++;
                    }
                }
                boolean dSz = com.tencent.mm.plugin.gallery.a.d.dSz();
                if (com.tencent.mm.plugin.recordvideo.activity.a.b.q(arrayList2, arrayList3) != 4 || !dSz) {
                    intent.putStringArrayListExtra("key_select_video_list", arrayList3);
                    intent.putStringArrayListExtra("key_select_image_list", arrayList2);
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(111475);
                } else {
                    VLogPreloadUI.a aVar = VLogPreloadUI.xsx;
                    VLogPreloadUI.a.a(this, arrayList3, arrayList2, iArr);
                    AppMethodBeat.o(111475);
                }
            } else {
                if (i4 == 1) {
                    intent.putExtra("CropImage_Compress_Img", this.xob || !this.qoL);
                    ArrayList<GalleryItem.MediaItem> arrayList4 = this.xnQ.xnp;
                    ArrayList<String> arrayList5 = new ArrayList<>();
                    Iterator<GalleryItem.MediaItem> it3 = arrayList4.iterator();
                    while (it3.hasNext()) {
                        GalleryItem.MediaItem next3 = it3.next();
                        if (!next3.mMimeType.equals("edit") || Util.isNullOrNil(next3.xiY)) {
                            arrayList5.add(next3.xiW);
                        } else {
                            arrayList5.add(next3.xiY);
                        }
                    }
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList5);
                    intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
                    this.xom = 0;
                    setResult(-1, intent);
                    if (!Util.isNullOrNil(this.xnr) && this.xnr.equals("album_business_bubble_media_by_coordinate")) {
                        intent.putExtra("CropImage_Compress_Img", false);
                    }
                    if (Util.currentTicks() - this.xol < 1000) {
                        Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
                        AppMethodBeat.o(111475);
                    } else {
                        Log.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
                        this.xol = Util.currentTicks();
                        if (Util.isNullOrNil(this.dRL) || "medianote".equals(this.toUser)) {
                            finish();
                        } else {
                            intent.setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                            intent.putExtra("GalleryUI_FromUser", this.dRL);
                            intent.putExtra("GalleryUI_ToUser", this.toUser);
                            startActivityForResult(intent, 4373);
                        }
                    }
                } else if (i4 == 2) {
                    Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                    if (getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {
                        dSv = 0;
                    } else {
                        com.tencent.mm.plugin.gallery.ui.a.a azf = com.tencent.mm.plugin.gallery.ui.a.a.azf(this.xnQ.dRL().get(0));
                        azf.mSize = this.xon;
                        dSv = azf.dSv();
                    }
                    if (dSv == 0) {
                        intent.setData(FileProviderHelper.getUriForFile(getContext(), new com.tencent.mm.vfs.o(this.xnQ.dRL().get(0))));
                        intent.putStringArrayListExtra("key_select_video_list", this.xnQ.dRL());
                        setResult(-1, intent);
                        finish();
                    } else if (dSv == 2) {
                        com.tencent.mm.ui.base.h.n(this, R.string.hwl, R.string.dn8);
                        Log.w("MicroMsg.AlbumPreviewUI", "video is import error");
                        AppMethodBeat.o(111475);
                    } else {
                        com.tencent.mm.ui.base.h.n(this, R.string.dn7, R.string.dn8);
                        Log.w("MicroMsg.AlbumPreviewUI", "video is over size");
                        AppMethodBeat.o(111475);
                    }
                } else if (i4 != 3) {
                    Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                    setResult(-2);
                    finish();
                } else if (!Util.isNullOrNil(this.xnr) && this.xnr.equals("album_business_bubble_media_by_coordinate")) {
                    ArrayList<GalleryItem.MediaItem> arrayList6 = this.xnQ.xnp;
                    ArrayList<String> arrayList7 = new ArrayList<>();
                    ArrayList<String> arrayList8 = new ArrayList<>();
                    Iterator<GalleryItem.MediaItem> it4 = arrayList6.iterator();
                    while (it4.hasNext()) {
                        GalleryItem.MediaItem next4 = it4.next();
                        if (next4.getType() == 1) {
                            if (!next4.mMimeType.equals("edit") || Util.isNullOrNil(next4.xiY)) {
                                arrayList8.add(next4.xiW);
                            } else {
                                arrayList8.add(next4.xiY);
                            }
                        } else if (next4.getType() == 2) {
                            arrayList7.add(next4.xiW);
                        }
                    }
                    intent.putExtra("CropImage_Compress_Img", false);
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList8);
                    intent.putStringArrayListExtra("key_select_video_list", arrayList7);
                    intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
                    intent.putExtra("longitude", this.longitude);
                    intent.putExtra("latitude", this.latitude);
                    this.xom = 0;
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(111475);
                } else if (Util.currentTicks() - this.xol < 1000) {
                    Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
                    AppMethodBeat.o(111475);
                } else {
                    this.xol = Util.currentTicks();
                    ArrayList<GalleryItem.MediaItem> arrayList9 = this.xnQ.xnp;
                    ArrayList<String> arrayList10 = new ArrayList<>();
                    ArrayList<String> arrayList11 = new ArrayList<>();
                    int[] iArr2 = new int[this.wnd];
                    Iterator<GalleryItem.MediaItem> it5 = arrayList9.iterator();
                    int i5 = 0;
                    while (it5.hasNext()) {
                        GalleryItem.MediaItem next5 = it5.next();
                        if (next5.getType() == 1) {
                            if (!next5.mMimeType.equals("edit") || Util.isNullOrNil(next5.xiY)) {
                                arrayList11.add(next5.xiW);
                            } else {
                                arrayList11.add(next5.xiY);
                            }
                            iArr2[i5] = 1;
                            i5++;
                        } else {
                            if (next5.getType() == 2) {
                                arrayList10.add(next5.xiW);
                                i2 = i5 + 1;
                                iArr2[i5] = 2;
                            } else {
                                i2 = i5;
                            }
                            i5 = i2;
                        }
                    }
                    intent.putExtra("CropImage_Compress_Img", this.xob || !this.qoL);
                    intent.putStringArrayListExtra("key_select_video_list", arrayList10);
                    intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
                    if (!this.xob) {
                        this.xom = 0;
                        if (arrayList11.size() > 0) {
                            intent.setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                            intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList11);
                            intent.putExtra("GalleryUI_FromUser", this.dRL);
                            intent.putExtra("GalleryUI_ToUser", this.toUser);
                            intent.putExtra("CropImage_limit_Img_Size", 26214400);
                            Log.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE_AND_VIDEO switch to SendImgProxyUI");
                            startActivityForResult(intent, 4373);
                        } else {
                            Log.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                            setResult(-1, intent);
                            finish();
                        }
                    } else if (arrayList10.size() == 0) {
                        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList11);
                        intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
                        this.xom = 0;
                        setResult(-1, intent);
                        finish();
                        AppMethodBeat.o(111475);
                    } else {
                        if (com.tencent.mm.plugin.recordvideo.activity.a.b.q(arrayList11, arrayList10) == 4) {
                            VLogPreloadUI.a aVar2 = VLogPreloadUI.xsx;
                            VLogPreloadUI.a.a(this, arrayList10, arrayList11, iArr2);
                        } else {
                            RecordConfigProvider aD = RecordConfigProvider.aD(arrayList10.get(0), "", "");
                            aD.BOv = getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000;
                            aD.scene = 2;
                            VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                            videoCaptureReportInfo.sQn = 1;
                            aD.BOE = videoCaptureReportInfo;
                            UICustomParam.a aVar3 = new UICustomParam.a();
                            aVar3.apE();
                            aVar3.apD();
                            aVar3.dz(true);
                            aD.BOn = aVar3.gLU;
                            com.tencent.mm.plugin.recordvideo.jumper.a aVar4 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, R.anim.ei, -1, aD, 2, 0);
                        }
                        AppMethodBeat.o(111475);
                    }
                }
                AppMethodBeat.o(111475);
            }
        }
        return true;
    }

    private void dRW() {
        AppMethodBeat.i(111476);
        if (!com.tencent.mm.pluginsdk.ui.tools.s.d(getContext(), com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369)) {
            Toast.makeText(getContext(), getString(R.string.gix), 1).show();
            AppMethodBeat.o(111476);
            return;
        }
        System.gc();
        AppMethodBeat.o(111476);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(111477);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            Log.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.xnU == null || !this.xnU.jT) {
                this.krh = true;
                finish();
                AppMethodBeat.o(111477);
                return true;
            }
            this.xnU.dSg();
            playActionBarOperationAreaAnim();
            AppMethodBeat.o(111477);
            return true;
        } else if (i2 == 82) {
            this.xok++;
            if (this.xnU != null) {
                this.xnU.dSg();
            }
            AppMethodBeat.o(111477);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(111477);
            return onKeyDown;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(111478);
        Log.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d] %s.", Integer.valueOf(i2), Integer.valueOf(i3), this);
        if (4369 != i2) {
            if (4370 != i2) {
                if (4371 != i2) {
                    if (4372 != i2) {
                        if (4373 == i2) {
                            if (intent != null) {
                                intent.putExtra("GalleryUI_IsSendImgBackground", true);
                                Log.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                            }
                            Log.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                            setResult(-1, intent);
                            this.xoi = true;
                            finish();
                        } else if (4378 != i2) {
                            if (4375 != i2) {
                                if (4376 != i2) {
                                    if (4377 != i2) {
                                        if (i2 == 4379) {
                                            if (i3 == -1 && intent != null) {
                                                CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                                                intent.putExtra("key_extra_data", intent.getBundleExtra("key_extra_data"));
                                                intent.putExtra("K_SEGMENTVIDEOPATH", captureVideoNormalModel.videoPath);
                                                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", captureVideoNormalModel.thumbPath);
                                                intent.putExtra("KSEGMENTMEDIAEDITID", new StringBuilder().append(captureVideoNormalModel.eJJ().y("KEY_EDIT_PUBLISHID_INT", -1)).toString());
                                                this.xnP = true;
                                                setResult(-1, intent);
                                                finish();
                                            } else if (i3 == -2) {
                                                finish();
                                            }
                                            if ((i3 == 0 || -2 == i3) && !Util.isNullOrNil(this.xoF)) {
                                                com.tencent.mm.plugin.gallery.a aVar = a.C1384a.xhE;
                                                String str = this.xoF;
                                                Log.i("MicroMsg.GalleryReporter", "path: %s.", str);
                                                if (!Util.isNullOrNil(str)) {
                                                    aVar.xhy.remove(str);
                                                    aVar.xhz.remove(str);
                                                    aVar.xhA.remove(str);
                                                    aVar.xhB.remove(str);
                                                    aVar.xhC.remove(str);
                                                    aVar.xhD.remove(str);
                                                }
                                            }
                                        } else if (4382 == i2) {
                                            Log.i("MicroMsg.AlbumPreviewUI", "back from smart gallery.");
                                            if (intent != null) {
                                                Bundle extras = intent.getExtras();
                                                this.qoL = intent.getBooleanExtra("send_raw_img", this.qoL);
                                                if (this.qoL) {
                                                    this.xnW.setImageResource(R.raw.radio_on);
                                                } else {
                                                    this.xnW.setImageResource(R.raw.radio_off);
                                                }
                                                if (this.xof) {
                                                    this.xnW.setImageResource(R.raw.radio_default_on);
                                                }
                                                this.xnW.setEnabled(!this.xof);
                                                this.xnV.setEnabled(!this.xof);
                                                if (extras != null) {
                                                    for (String str2 : extras.keySet()) {
                                                        Log.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", str2, extras.get(str2));
                                                    }
                                                }
                                            }
                                            if (-2 == i3 || i3 == 0 || SmartGalleryUI.xrW == i3) {
                                                Log.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
                                                android.support.v4.e.b<Integer> bVar = new android.support.v4.e.b<>();
                                                for (int i4 = 0; i4 < this.xnQ.xnp.size(); i4++) {
                                                    int indexOf = this.xnQ.xno.indexOf(this.xnQ.xnp.get(i4));
                                                    if (indexOf != -1) {
                                                        bVar.add(Integer.valueOf(indexOf));
                                                    }
                                                }
                                                this.xnQ.eX(s.dRv().xjH);
                                                if (SmartGalleryUI.xrW == i3) {
                                                    dyR();
                                                    AppMethodBeat.o(111478);
                                                    return;
                                                }
                                                NM(this.xnQ.xnp.size());
                                                this.xnQ.a(bVar);
                                                AppMethodBeat.o(111478);
                                                return;
                                            }
                                            if (-1 == i3) {
                                                this.xnP = true;
                                            }
                                            setResult(i3, intent);
                                            finish();
                                        } else if (i2 != 4381) {
                                            switch (i3) {
                                                case -2:
                                                    Log.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                                    finish();
                                                    break;
                                                case -1:
                                                    if (intent == null) {
                                                        intent = new Intent();
                                                        intent.putExtra("CropImage_Compress_Img", true);
                                                        intent.putStringArrayListExtra("CropImage_OutputPath_List", this.xnQ.dRL());
                                                    }
                                                    intent.putStringArrayListExtra("key_select_image_list", intent.getStringArrayListExtra("CropImage_OutputPath_List"));
                                                    Log.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                                    this.xnP = true;
                                                    setResult(-1, intent);
                                                    finish();
                                                    break;
                                                case 0:
                                                    if (intent != null) {
                                                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                        Object[] objArr = new Object[1];
                                                        objArr[0] = Integer.valueOf(stringArrayListExtra == null ? 0 : stringArrayListExtra.size());
                                                        Log.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", objArr);
                                                        if (!(stringArrayListExtra == null || this.xnQ == null)) {
                                                            android.support.v4.e.b<Integer> bVar2 = new android.support.v4.e.b<>();
                                                            for (int i5 = 0; i5 < this.xnQ.xnp.size(); i5++) {
                                                                int indexOf2 = this.xnQ.xno.indexOf(this.xnQ.xnp.get(i5));
                                                                if (indexOf2 != -1) {
                                                                    bVar2.add(Integer.valueOf(indexOf2));
                                                                }
                                                            }
                                                            this.xnQ.aq(stringArrayListExtra);
                                                            this.xnQ.a(bVar2);
                                                            NM(stringArrayListExtra.size());
                                                        }
                                                        this.qoL = !intent.getBooleanExtra("CropImage_Compress_Img", true);
                                                        if (this.qoL) {
                                                            this.xnW.setImageResource(R.raw.radio_on);
                                                        } else {
                                                            this.xnW.setImageResource(R.raw.radio_off);
                                                        }
                                                        if (this.xof) {
                                                            this.xnW.setImageResource(R.raw.radio_default_on);
                                                        }
                                                        this.xnW.setEnabled(!this.xof);
                                                        this.xnV.setEnabled(!this.xof);
                                                        break;
                                                    }
                                                    break;
                                            }
                                        } else if (i3 != -1) {
                                            Toast.makeText(this, (int) R.string.eka, 1).show();
                                        } else if (this.xob) {
                                            RecordConfigProvider jB = RecordConfigProvider.jB("", "");
                                            jB.BOv = getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000;
                                            jB.scene = 2;
                                            VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                                            videoCaptureReportInfo.sQn = 1;
                                            jB.BOE = videoCaptureReportInfo;
                                            UICustomParam.a aVar2 = new UICustomParam.a();
                                            aVar2.apE();
                                            aVar2.apD();
                                            aVar2.dz(true);
                                            jB.BOn = aVar2.gLU;
                                            com.tencent.mm.plugin.recordvideo.jumper.a aVar3 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                                            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, R.anim.ei, -1, jB, 4, 0);
                                            AppMethodBeat.o(111478);
                                            return;
                                        } else if (22 == com.tencent.mm.plugin.gallery.model.e.dQK().mcq) {
                                            setResult(-1, intent);
                                            finish();
                                            AppMethodBeat.o(111478);
                                            return;
                                        }
                                    } else if (i3 == -1) {
                                        setResult(-1, intent);
                                        finish();
                                    }
                                } else if (-1 != i3) {
                                    Log.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    GalleryItem.AlbumItem albumItem = (GalleryItem.AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    b(albumItem);
                                    setMMTitle(Util.nullAs(albumItem.albumName, getString(R.string.dli)));
                                }
                            } else if (-1 != i3) {
                                AppMethodBeat.o(111478);
                                return;
                            } else {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                Log.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", intent);
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    Log.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                    AppMethodBeat.o(111478);
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                String str3 = sightCaptureResult.zsA;
                                if (!Util.isNullOrNil(str3)) {
                                    arrayList.add(str3);
                                    intent.putExtra("key_select_video_list", arrayList);
                                }
                                if (sightCaptureResult.zsy && !Util.isNullOrNil(sightCaptureResult.zsG)) {
                                    ArrayList<String> arrayList2 = new ArrayList<>();
                                    arrayList2.add(sightCaptureResult.zsG);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList2);
                                }
                                setResult(-1, intent);
                                finish();
                            }
                        } else if (-1 != i3) {
                            AppMethodBeat.o(111478);
                            return;
                        } else {
                            if (intent == null) {
                                intent = new Intent();
                            }
                            Log.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", intent);
                            CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel2 = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                            if (captureVideoNormalModel2 == null) {
                                Log.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                setResult(1);
                                finish();
                                AppMethodBeat.o(111478);
                                return;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            String str4 = captureVideoNormalModel2.videoPath;
                            if (!Util.isNullOrNil(str4)) {
                                arrayList3.add(str4);
                                intent.putExtra("key_select_video_list", arrayList3);
                            }
                            if (captureVideoNormalModel2.BOe.booleanValue() && !Util.isNullOrNil(captureVideoNormalModel2.thumbPath)) {
                                ArrayList<String> arrayList4 = new ArrayList<>();
                                arrayList4.add(captureVideoNormalModel2.thumbPath);
                                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                            }
                            setResult(-1, intent);
                            finish();
                        }
                    } else if (-1 != i3) {
                        AppMethodBeat.o(111478);
                        return;
                    } else {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        Log.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", intent);
                        ArrayList arrayList5 = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!Util.isNullOrNil(stringExtra)) {
                            arrayList5.add(stringExtra);
                            intent.putExtra("key_select_video_list", arrayList5);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    }
                } else if (-1 != i3) {
                    AppMethodBeat.o(111478);
                    return;
                } else {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    Log.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", intent);
                    setResult(-1, intent);
                    finish();
                }
            } else if (-1 != i3) {
                AppMethodBeat.o(111478);
                return;
            } else if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                Log.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(111478);
                return;
            } else {
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.isEmpty()) {
                    Log.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    AppMethodBeat.o(111478);
                    return;
                }
                Log.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", stringArrayListExtra2);
                setResult(-1, intent);
                finish();
            }
        } else if (-1 != i3) {
            AppMethodBeat.o(111478);
            return;
        } else {
            String h2 = com.tencent.mm.pluginsdk.ui.tools.s.h(getContext().getApplicationContext(), intent, com.tencent.mm.loader.j.b.aKV());
            if (Util.isNullOrNil(h2)) {
                Log.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                AppMethodBeat.o(111478);
                return;
            }
            Log.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", h2);
            if (this.het == 0 || this.het == 5 || this.het == 11 || this.het == 24) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(h2)));
                Log.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                ArrayList<String> arrayList6 = new ArrayList<>(1);
                arrayList6.add(h2);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.qoL);
                intent3.putExtra("key_force_hide_edit_image_button", this.xoc || this.xod);
                intent3.putExtra("key_force_show_raw_image_button", this.xoe);
                intent3.putExtra("key_is_raw_image_button_disable", this.xof);
                intent3.putStringArrayListExtra("preview_image_list", arrayList6);
                if (this.xnQ != null) {
                    intent3.putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
                }
                intent3.putExtra("GalleryUI_FromUser", this.dRL);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                intent3.putExtra("select_type_tag", this.jVX);
                startActivityForResult(intent3, 4370);
            }
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.xnT.setVisibility(0);
                this.xnT.setText(getString(R.string.fm1));
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.br);
                this.xnT.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass5 */
                    private Runnable xoI = new Runnable() {
                        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(111426);
                            AlbumPreviewUI.this.xnT.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.getContext(), R.anim.bs));
                            AlbumPreviewUI.this.xnT.setVisibility(8);
                            AppMethodBeat.o(111426);
                        }
                    };

                    {
                        AppMethodBeat.i(111427);
                        AppMethodBeat.o(111427);
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(111428);
                        AlbumPreviewUI.this.xnT.setVisibility(0);
                        AlbumPreviewUI.this.xnT.postDelayed(this.xoI, 4000);
                        AppMethodBeat.o(111428);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                sharedPreferences.edit().putBoolean("has_show_tip", true).apply();
            }
        }
        AppMethodBeat.o(111478);
    }

    /* access modifiers changed from: protected */
    public final void NM(int i2) {
        ArrayList<GalleryItem.MediaItem> arrayList;
        AppMethodBeat.i(111479);
        if (i2 == 0) {
            this.xnN.setEnabled(false);
            enableOptionMenu(false);
        } else {
            this.xnN.setEnabled(true);
            enableOptionMenu(true);
        }
        if (i2 == 0) {
            this.xnN.setText(R.string.dm9);
        } else {
            this.xnN.setText(getString(R.string.dm9) + "(" + i2 + ")");
        }
        int i3 = this.het;
        int i4 = this.wnd;
        String str = this.xnr;
        if (this.xnQ == null) {
            arrayList = null;
        } else {
            arrayList = this.xnQ.xnp;
        }
        updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.d.a(this, i3, i2, i4, str, arrayList));
        AppMethodBeat.o(111479);
    }

    /* access modifiers changed from: package-private */
    public enum b {
        CREATE,
        SKIP;

        public static b valueOf(String str) {
            AppMethodBeat.i(111451);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(111451);
            return bVar;
        }

        static {
            AppMethodBeat.i(111452);
            AppMethodBeat.o(111452);
        }
    }

    private static void eY(List<GalleryItem.MediaItem> list) {
        AppMethodBeat.i(111480);
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", Integer.valueOf(list.size()));
        LinkedList linkedList = new LinkedList();
        for (GalleryItem.MediaItem mediaItem : list) {
            if (!com.tencent.mm.vfs.s.YS(mediaItem.xiW)) {
                Log.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", mediaItem.xiW);
                linkedList.add(mediaItem);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            list.remove((GalleryItem.MediaItem) it.next());
        }
        Log.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia cost: %s.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(111480);
    }

    @Override // com.tencent.mm.plugin.gallery.model.i.c
    public final void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
        boolean z2;
        AppMethodBeat.i(111481);
        if (j2 != this.xov) {
            Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j2), Long.valueOf(this.xov));
            Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            AppMethodBeat.o(111481);
            return;
        }
        Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", Boolean.valueOf(z), Integer.valueOf(this.xnQ.xno.size()), Integer.valueOf(linkedList.size()));
        if (z || this.xnQ.xno.size() > linkedList.size()) {
            eY(linkedList);
        } else {
            eY(linkedList.subList(this.xnQ.xno.size(), linkedList.size()));
        }
        LinkedList<GalleryItem.MediaItem> linkedList2 = new LinkedList<>(linkedList);
        Object[] objArr = new Object[2];
        if (this.xnQ == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        objArr[1] = Util.getStack().toString();
        Log.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", objArr);
        if (this.xnQ != null) {
            c cVar = new c((byte) 0);
            cVar.xoS = new WeakReference<>(this.xnQ);
            cVar.xoT = new WeakReference<>(this.gtM);
            cVar.xoU = new WeakReference<>(this.xnS);
            cVar.xoV = new WeakReference<>(this.xnM);
            cVar.xoW = linkedList2;
            cVar.xop = this.xop;
            cVar.xoY = z;
            if (b.CREATE == this.xoz) {
                this.xoz = b.SKIP;
            }
            com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(cVar);
        }
        AppMethodBeat.o(111481);
    }

    static class c implements Runnable {
        WeakReference<a> xoS;
        WeakReference<ProgressDialog> xoT;
        WeakReference<TextView> xoU;
        WeakReference<RecyclerView> xoV;
        LinkedList<GalleryItem.MediaItem> xoW;
        WeakReference<ImageFolderMgrView> xoX;
        boolean xoY;
        String xop;

        private c() {
            this.xoY = false;
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void run() {
            ImageFolderMgrView imageFolderMgrView;
            int size;
            AppMethodBeat.i(111455);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.xoW == null ? -1 : this.xoW.size());
            Log.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", objArr);
            AlbumPreviewUI.aO(this.xoW);
            if (this.xoS == null) {
                Log.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
                AppMethodBeat.o(111455);
                return;
            }
            a aVar = this.xoS.get();
            if (aVar == null) {
                Log.w("MicroMsg.AlbumPreviewUI", "null == adapter");
                AppMethodBeat.o(111455);
            } else if (this.xoV == null) {
                AppMethodBeat.o(111455);
            } else {
                RecyclerView recyclerView = this.xoV.get();
                if (recyclerView == null) {
                    AppMethodBeat.o(111455);
                    return;
                }
                Log.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", Boolean.valueOf(this.xoY));
                p.a aVar2 = p.xjw;
                p.dRt().eU(this.xoW);
                if (this.xoY) {
                    this.xoY = false;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    aVar.aM(this.xoW);
                    p.a aVar3 = p.xjw;
                    p dRt = p.dRt();
                    p.c cVar = p.c.IDLE;
                    if (this.xoW.size() > 32) {
                        size = 32;
                    } else {
                        size = this.xoW.size();
                    }
                    dRt.a(cVar, 0, size, aVar.xno.size());
                } else {
                    aVar.aN(this.xoW);
                }
                if (this.xoT == null) {
                    AppMethodBeat.o(111455);
                    return;
                }
                ProgressDialog progressDialog = this.xoT.get();
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    Log.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start));
                }
                if (!(this.xoX == null || (imageFolderMgrView = this.xoX.get()) == null)) {
                    imageFolderMgrView.setFavItemCount(this.xoW.size());
                }
                if (this.xoU == null || Util.isNullOrNil(this.xop)) {
                    AppMethodBeat.o(111455);
                    return;
                }
                final TextView textView = this.xoU.get();
                if (textView != null) {
                    String NL = aVar.NL(((GridLayoutManager) recyclerView.getLayoutManager()).ks());
                    if (!Util.isNullOrNil(NL) && NL.equals("album_business_bubble_media_by_coordinate")) {
                        textView.setVisibility(0);
                        textView.setText(this.xop.concat("附近的照片和视频"));
                        textView.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.c.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(111454);
                                if (8 == textView.getVisibility()) {
                                    AppMethodBeat.o(111454);
                                    return;
                                }
                                textView.animate().alpha(0.0f).setDuration(300).withEndAction(new Runnable() {
                                    /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.c.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(111453);
                                        textView.setVisibility(8);
                                        textView.setAlpha(1.0f);
                                        AppMethodBeat.o(111453);
                                    }
                                });
                                AppMethodBeat.o(111454);
                            }
                        }, 2000);
                    }
                }
                AppMethodBeat.o(111455);
            }
        }

        public final String toString() {
            AppMethodBeat.i(111456);
            String str = super.toString() + "|NotifyMediaItemsChanged";
            AppMethodBeat.o(111456);
            return str;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(111483);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(111483);
            return;
        }
        Log.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] == 0) {
                    dRW();
                    AppMethodBeat.o(111483);
                    return;
                }
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.dlk), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass6 */

                    {
                        AppMethodBeat.i(173753);
                        AppMethodBeat.o(173753);
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(111429);
                        AlbumPreviewUI albumPreviewUI = AlbumPreviewUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(albumPreviewUI, bl.axQ(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        albumPreviewUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(albumPreviewUI, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(111429);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(111483);
                return;
            case 145:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl6), getString(R.string.flp), getString(R.string.e_k), getString(R.string.dlk), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(173755);
                            AlbumPreviewUI albumPreviewUI = AlbumPreviewUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(albumPreviewUI, bl.axQ(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            albumPreviewUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(albumPreviewUI, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AlbumPreviewUI.this.finish();
                            AppMethodBeat.o(173755);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(173756);
                            AlbumPreviewUI.this.finish();
                            AppMethodBeat.o(173756);
                        }
                    });
                    break;
                } else {
                    dRU();
                    com.tencent.mm.plugin.gallery.model.e.dQK().dRr();
                    dRV();
                    AppMethodBeat.o(111483);
                    return;
                }
        }
        AppMethodBeat.o(111483);
    }

    /* access modifiers changed from: protected */
    public boolean a(GalleryItem.MediaItem mediaItem) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem r8) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.b(com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem):boolean");
    }

    private void dRX() {
        AppMethodBeat.i(257740);
        if (this.xoB == null) {
            this.xoB = new HashSet<>();
            this.xoB.add(".h264");
            this.xoB.add(".h26l");
            this.xoB.add(".264");
            this.xoB.add(".avc");
            this.xoB.add(".mov");
            this.xoB.add(".mp4");
            this.xoB.add(".m4a");
            this.xoB.add(".3gp");
            this.xoB.add(".3g2");
            this.xoB.add(".mj2");
            this.xoB.add(".m4v");
        }
        AppMethodBeat.o(257740);
    }

    public final boolean bG(String str, boolean z) {
        AppMethodBeat.i(257741);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(257741);
            return true;
        }
        dRX();
        String trim = str.trim();
        int lastIndexOf = trim.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf >= trim.length()) {
            AppMethodBeat.o(257741);
            return true;
        } else if (z && r.Ql(trim)) {
            AppMethodBeat.o(257741);
            return true;
        } else if (!this.xoB.contains(trim.substring(lastIndexOf).toLowerCase())) {
            AppMethodBeat.o(257741);
            return true;
        } else {
            AppMethodBeat.o(257741);
            return false;
        }
    }

    private void ayY(String str) {
        AppMethodBeat.i(173773);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
            AppMethodBeat.o(173773);
            return;
        }
        com.tencent.mm.plugin.gallery.model.e.dQL().ar(new d(str, this.xnQ, this.gtM, this.xnM));
        AppMethodBeat.o(173773);
    }

    /* access modifiers changed from: package-private */
    public static class d implements Runnable {
        private String xpc;
        private WeakReference<a> xpd;
        private WeakReference<ProgressDialog> xpe;
        private WeakReference<RecyclerView> xpf;

        d(String str, a aVar, ProgressDialog progressDialog, RecyclerView recyclerView) {
            AppMethodBeat.i(111458);
            this.xpc = str;
            this.xpd = new WeakReference<>(aVar);
            this.xpe = new WeakReference<>(progressDialog);
            this.xpf = new WeakReference<>(recyclerView);
            AppMethodBeat.o(111458);
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(111459);
            if (Util.isNullOrNil(this.xpc)) {
                AppMethodBeat.o(111459);
                return;
            }
            Log.i("QuerySmartGalleryAlbumMediaTask", "start query.");
            s dRv = s.dRv();
            String str = this.xpc;
            AnonymousClass1 r10 = new s.h() {
                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.gallery.model.s.h
                public final void f(List<s.g> list, boolean z) {
                    a aVar;
                    AppMethodBeat.i(161161);
                    if (!(d.this.xpd == null || (aVar = (a) d.this.xpd.get()) == null)) {
                        if (z || aVar.xno.size() > list.size()) {
                            d.eZ(list);
                        } else {
                            d.eZ(list.subList(aVar.xno.size(), list.size()));
                        }
                    }
                    LinkedList<GalleryItem.MediaItem> linkedList = new LinkedList<>();
                    for (s.g gVar : list) {
                        if (gVar.type.contains("image")) {
                            GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(1, gVar.xjW, gVar.data, "", gVar.type);
                            a2.xja = gVar.xjX;
                            linkedList.add(a2);
                        } else if (gVar.type.contains("video")) {
                            GalleryItem.MediaItem a3 = GalleryItem.MediaItem.a(2, gVar.xjW, gVar.data, "", gVar.type);
                            a3.xja = gVar.xjX;
                            linkedList.add(a3);
                        }
                    }
                    c cVar = new c((byte) 0);
                    cVar.xoS = d.this.xpd;
                    cVar.xoT = d.this.xpe;
                    cVar.xoW = linkedList;
                    cVar.xoV = d.this.xpf;
                    cVar.xoY = z;
                    com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(cVar);
                    Log.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
                    AppMethodBeat.o(161161);
                }
            };
            dRv.xjF = false;
            ArrayList arrayList = new ArrayList();
            Cursor query = dRv.hwt.query(s.BASE_URI.buildUpon().appendEncodedPath("albumInfo").build(), new String[]{"_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude"}, "albumID=?", new String[]{str}, null);
            if (query != null) {
                int columnIndex = query.getColumnIndex("_id");
                int columnIndex2 = query.getColumnIndex("_data");
                int columnIndex3 = query.getColumnIndex("mime_type");
                int columnIndex4 = query.getColumnIndex("datetaken");
                z = true;
                while (true) {
                    if (query.moveToNext()) {
                        if (dRv.xjF) {
                            break;
                        }
                        s.g gVar = new s.g();
                        gVar.xjW = Util.safeParseLong(query.getString(columnIndex));
                        gVar.data = query.getString(columnIndex2);
                        gVar.type = query.getString(columnIndex3);
                        gVar.xjX = Util.safeParseLong(query.getString(columnIndex4));
                        Log.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", Long.valueOf(gVar.xjW), gVar.data, gVar.type);
                        arrayList.add(gVar);
                        if (arrayList.size() % dRv.eT == 0) {
                            r10.f(arrayList, z);
                            if (z) {
                                z = false;
                            }
                        }
                    } else {
                        query.close();
                        break;
                    }
                }
                AppMethodBeat.o(111459);
            }
            z = true;
            r10.f(arrayList, z);
            AppMethodBeat.o(111459);
        }

        static /* synthetic */ void eZ(List list) {
            AppMethodBeat.i(257738);
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("QuerySmartGalleryAlbumMediaTask", "filterNonExistMedia size: %s.", Integer.valueOf(list.size()));
            LinkedList linkedList = new LinkedList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                s.g gVar = (s.g) it.next();
                if (!com.tencent.mm.vfs.s.YS(gVar.data)) {
                    Log.w("QuerySmartGalleryAlbumMediaTask", "filter non exist media: %s.", gVar.data);
                    linkedList.add(gVar);
                }
            }
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                list.remove((s.g) it2.next());
            }
            Log.d("QuerySmartGalleryAlbumMediaTask", "filterNonExistMedia cost: %s.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(257738);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        WeakReference<AlbumPreviewUI> mZg;

        a(AlbumPreviewUI albumPreviewUI) {
            AppMethodBeat.i(111448);
            this.mZg = new WeakReference<>(albumPreviewUI);
            AppMethodBeat.o(111448);
        }

        public final void run() {
            AppMethodBeat.i(111449);
            long currentTimeMillis = System.currentTimeMillis();
            boolean dRx = s.dRv().dRx();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Log.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", Boolean.valueOf(dRx), Long.valueOf(currentTimeMillis2));
            h.INSTANCE.a(19165, Long.valueOf(currentTimeMillis2));
            if (currentTimeMillis2 <= 3000) {
                h.INSTANCE.dN(1297, 0);
            } else if (currentTimeMillis2 <= 5000) {
                h.INSTANCE.dN(1297, 1);
            } else if (currentTimeMillis2 <= 10000) {
                h.INSTANCE.dN(1297, 2);
            } else if (currentTimeMillis2 <= 15000) {
                h.INSTANCE.dN(1297, 3);
            } else {
                h.INSTANCE.dN(1297, 4);
            }
            if (dRx) {
                a.C1384a.xhE.xhq = 1;
                com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.a.AnonymousClass1 */

                    public final void run() {
                        AlbumPreviewUI albumPreviewUI;
                        AppMethodBeat.i(111447);
                        if (!(a.this.mZg == null || (albumPreviewUI = a.this.mZg.get()) == null)) {
                            albumPreviewUI.setSmartGalleryEntryVisibility(true);
                            albumPreviewUI.xoC = true;
                        }
                        AppMethodBeat.o(111447);
                    }
                });
            }
            AppMethodBeat.o(111449);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e implements Runnable {
        List<Long> idList;
        int type;
        WeakReference<a> xoS;
        WeakReference<ProgressDialog> xoT;
        WeakReference<ImageFolderMgrView> xoX;
        boolean xph;

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final void run() {
            boolean z;
            int i2;
            AppMethodBeat.i(111462);
            s dRv = s.dRv();
            AnonymousClass1 r9 = new i.c() {
                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.e.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.gallery.model.i.c
                public final void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
                    AppMethodBeat.i(111461);
                    Log.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", Boolean.valueOf(e.this.xph));
                    if (e.this.xph) {
                        AppMethodBeat.o(111461);
                        return;
                    }
                    LinkedList<GalleryItem.MediaItem> linkedList2 = new LinkedList<>();
                    if (linkedList != null) {
                        linkedList2.addAll(linkedList);
                    }
                    Iterator<GalleryItem.MediaItem> it = linkedList2.iterator();
                    while (it.hasNext()) {
                        GalleryItem.MediaItem next = it.next();
                        Log.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", next.mMimeType, next.xiW);
                    }
                    c cVar = new c((byte) 0);
                    cVar.xoS = e.this.xoS;
                    cVar.xoT = e.this.xoT;
                    cVar.xoW = linkedList2;
                    cVar.xoX = e.this.xoX;
                    com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(cVar);
                    AppMethodBeat.o(111461);
                }
            };
            List<Long> list = this.idList;
            int i3 = this.type;
            dRv.xjG = false;
            LinkedList<GalleryItem.MediaItem> linkedList = new LinkedList<>();
            if (Util.isNullOrNil(list)) {
                Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
                Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", Integer.valueOf(i3));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                switch (i3) {
                    case 1:
                        arrayList2.add(2);
                        break;
                    case 2:
                        arrayList2.add(4);
                        break;
                    case 3:
                        arrayList2.add(21);
                        break;
                    default:
                        arrayList2.add(2);
                        break;
                }
                ArrayList<Long> b2 = ((af) g.ah(af.class)).getFavSearchStorage().b(null, null, arrayList2);
                if (!Util.isNullOrNil(b2)) {
                    Log.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
                    arrayList.addAll(b2);
                }
                if (Util.isNullOrNil(arrayList)) {
                    Log.i("MicroMsg.SmartGalleryQueryUtil", "fav list do not contain img or video.");
                    r9.b(linkedList, -1, true);
                    AppMethodBeat.o(111462);
                    return;
                }
                list = arrayList;
            }
            int size = list.size();
            Log.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", Integer.valueOf(size));
            int i4 = size < 100 ? size : 100;
            int i5 = i4 + 0;
            boolean z2 = true;
            int i6 = i4;
            int i7 = 0;
            while (!dRv.xjG) {
                Log.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", Integer.valueOf(i6));
                linkedList.addAll(s.w(list.subList(i7, i5), i3));
                r9.b(linkedList, -1, z2);
                if (z2) {
                    z = false;
                } else {
                    z = z2;
                }
                int size2 = size - linkedList.size();
                if (size2 > 0) {
                    if (size2 >= 100) {
                        size2 = 100;
                    }
                    i2 = i5 + size2;
                    i6 = size2;
                    i7 = i5;
                } else {
                    i2 = i5;
                }
                if (i2 >= size) {
                    AppMethodBeat.o(111462);
                } else {
                    z2 = z;
                    i5 = i2;
                }
            }
            AppMethodBeat.o(111462);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(111484);
        getIntent().putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
        getIntent().putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(111484);
    }

    private void dRY() {
        AppMethodBeat.i(111485);
        String stringExtra = getIntent().getStringExtra("to_user");
        String stringExtra2 = getIntent().getStringExtra("file_name");
        String stringExtra3 = getIntent().getStringExtra("video_path");
        String stringExtra4 = getIntent().getStringExtra("video_full_path");
        String stringExtra5 = getIntent().getStringExtra("video_thumb_path");
        try {
            Intent intent = new Intent();
            intent.setClassName(getContext().getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
            intent.putExtra("VideoRecorder_ToUser", stringExtra);
            intent.putExtra("VideoRecorder_FileName", stringExtra2);
            intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
            intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
            intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
            Log.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", intent);
            startActivityForResult(intent, 4371);
            AppMethodBeat.o(111485);
        } catch (Exception e2) {
            Log.w("MicroMsg.AlbumPreviewUI", e2.toString());
            if (!com.tencent.mm.q.a.o(getContext(), true) && !com.tencent.mm.q.a.cA(getContext()) && !com.tencent.mm.q.a.cE(getContext())) {
                com.tencent.mm.compatible.i.b.w(getContext());
            }
            AppMethodBeat.o(111485);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean isActionbarCenterLayoutMode() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void g(final int i2, View view) {
        boolean z;
        ArrayList<GalleryItem.MediaItem> NJ;
        boolean z2;
        AppMethodBeat.i(164801);
        final GalleryItem.MediaItem NK = this.xnQ.NK(i2);
        if (NK == null || Util.isNullOrNil(NK.xiW)) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(NK == null);
            Log.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", objArr);
            AppMethodBeat.o(164801);
        } else if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 5 || !NK.mMimeType.equalsIgnoreCase("image/gif")) {
            if (1 == this.xos) {
                if (NK.mMimeType.toLowerCase().contains("video")) {
                    com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.dmv));
                    AppMethodBeat.o(164801);
                    return;
                }
            } else if (2 == this.xos && NK.mMimeType.toLowerCase().contains("image")) {
                com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.dmu));
                AppMethodBeat.o(164801);
                return;
            }
            int size = i2 - this.xnQ.xns.size();
            Log.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", Integer.valueOf(this.het), NK);
            if (this.het == 0 || this.het == 5 || this.het == 10 || this.het == 11 || this.het == 27) {
                if (this.xos == 2) {
                    com.tencent.mm.ui.base.h.a((Context) this, true, getString(R.string.dn9), "", getString(R.string.yq), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(179459);
                            Log.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
                            Intent intent = new Intent();
                            intent.setData(Uri.parse("file://" + Uri.encode(NK.xiW)));
                            AlbumPreviewUI.this.setResult(-1, intent);
                            a.C1384a.xhE.al(NK.xiW, AlbumPreviewUI.this.jVX, i2);
                            AlbumPreviewUI.this.finish();
                            AppMethodBeat.o(179459);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(164801);
                    return;
                }
                float floatExtra = getIntent().getFloatExtra("album_min_ratio_limit", -1.0f);
                float floatExtra2 = getIntent().getFloatExtra("album_max_ratio_limit", -1.0f);
                if (floatExtra >= 0.0f || floatExtra2 >= 0.0f) {
                    int i3 = 0;
                    int i4 = 0;
                    if (NK instanceof GalleryItem.ImageMediaItem) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        MMBitmapFactory.decodeFile(NK.xiW, options);
                        i3 = options.outWidth;
                        i4 = options.outHeight;
                    }
                    if (i3 == 0 || i4 == 0) {
                        z = false;
                    } else {
                        float f2 = ((float) i3) / ((float) i4);
                        if ((floatExtra < 0.0f || f2 >= floatExtra) && (floatExtra2 < 0.0f || f2 <= floatExtra2)) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                } else {
                    z = true;
                }
                if (!z) {
                    Log.i("MicroMsg.AlbumPreviewUI", "not support ratio");
                    String str = null;
                    if (NK instanceof GalleryItem.ImageMediaItem) {
                        str = getResources().getString(R.string.dmw);
                    }
                    if (str != null) {
                        com.tencent.mm.ui.base.h.cD(getContext(), str);
                    }
                    AppMethodBeat.o(164801);
                    return;
                }
                Intent intent = new Intent();
                if (NK.getType() == 2) {
                    intent.putExtra("is_video", true);
                    intent.putExtra("video_full_path", NK.xiW);
                }
                if (this.het == 10) {
                    intent.putExtra("CropImage_OutputPath", NK.xiW);
                }
                intent.setData(Uri.parse(Uri.encode(NK.xiW)));
                Log.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                setResult(-1, intent);
                a.C1384a.xhE.al(NK.xiW, this.jVX, i2);
                finish();
                AppMethodBeat.o(164801);
            } else if (this.het == 4) {
                boolean dSy = com.tencent.mm.plugin.gallery.a.d.dSy();
                if (dSy || NK.getType() != 2 || this.xnQ.xnp.size() == 0) {
                    boolean z3 = dSy && com.tencent.mm.plugin.gallery.a.d.at(this.xnQ.xnp);
                    Log.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", Boolean.valueOf(dSy), Boolean.valueOf(z3));
                    if (NK.getType() != 2 || z3) {
                        Log.d("leextime", "jump from sns : " + Util.currentTicks());
                        if (dSy) {
                            NJ = this.xnQ.xno;
                        } else {
                            NJ = this.xnQ.NJ(NK.getType());
                        }
                        com.tencent.mm.plugin.gallery.model.e.ao(NJ);
                        Intent intent2 = new Intent(this, ImagePreviewUI.class);
                        intent2.putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                        intent2.putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
                        intent2.putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
                        intent2.putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
                        intent2.putExtra("preview_all", true);
                        intent2.putExtra("preview_position", NJ.indexOf(NK));
                        az(size, true);
                        intent2.putExtra("send_raw_img", this.qoL);
                        intent2.putExtra("key_force_hide_edit_image_button", this.xoc);
                        intent2.putExtra("key_force_show_raw_image_button", this.xoe);
                        intent2.putExtra("key_is_raw_image_button_disable", this.xof);
                        intent2.putExtra("max_select_count", this.wnd);
                        intent2.putExtra("GalleryUI_FromUser", this.dRL);
                        intent2.putExtra("GalleryUI_ToUser", this.toUser);
                        intent2.putExtra("select_type_tag", this.jVX);
                        startActivityForResult(intent2, 0);
                        AppMethodBeat.o(164801);
                        return;
                    }
                    com.tencent.mm.n.a aVar = com.tencent.mm.n.a.gLV;
                    long apI = (long) (com.tencent.mm.n.a.apI() * 1000);
                    com.tencent.mm.n.a aVar2 = com.tencent.mm.n.a.gLV;
                    String string = getString(R.string.dmj, new Object[]{Integer.valueOf(com.tencent.mm.n.a.apI() / 60)});
                    if (NK instanceof GalleryItem.VideoMediaItem) {
                        if (TPDecoderType.TP_CODEC_MIMETYPE_HEVC.equalsIgnoreCase(((GalleryItem.VideoMediaItem) NK).jkQ) && com.tencent.mm.plugin.n.f.ejb()) {
                            z2 = true;
                        } else if ("video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem) NK).jkQ)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (bG(NK.xiW, true) || !z2 || (!Util.isNullOrNil(((GalleryItem.VideoMediaItem) NK).jkR) && !EncoderWriter.OUTPUT_AUDIO_MIME_TYPE.equalsIgnoreCase(((GalleryItem.VideoMediaItem) NK).jkR))) {
                            f.a aVar3 = new f.a(getContext());
                            aVar3.aC(com.tencent.mm.cb.a.aI(getContext(), R.string.dme));
                            aVar3.boA(com.tencent.mm.cb.a.aI(getContext(), R.string.dlu));
                            aVar3.b(new f.c() {
                                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass13 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                }
                            });
                            aVar3.show();
                            AppMethodBeat.o(164801);
                            return;
                        } else if (((long) ((GalleryItem.VideoMediaItem) NK).jkS) >= apI) {
                            f.a aVar4 = new f.a(getContext());
                            aVar4.aC(string);
                            aVar4.boA(com.tencent.mm.cb.a.aI(getContext(), R.string.dlu));
                            aVar4.b(new f.c() {
                                /* class com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.AnonymousClass14 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                }
                            });
                            aVar4.show();
                            AppMethodBeat.o(164801);
                            return;
                        }
                    }
                    RecordConfigProvider aD = RecordConfigProvider.aD(NK.xiW, "", "");
                    aD.BOv = getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000;
                    aD.scene = 2;
                    VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                    videoCaptureReportInfo.sQn = 1;
                    aD.BOE = videoCaptureReportInfo;
                    UICustomParam.a aVar5 = new UICustomParam.a();
                    aVar5.apE();
                    aVar5.apD();
                    aVar5.dz(true);
                    aD.BOn = aVar5.gLU;
                    a.C1384a.xhE.al(NK.xiW, this.jVX, i2);
                    this.xoF = NK.xiW;
                    com.tencent.mm.plugin.recordvideo.jumper.a aVar6 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, R.anim.ei, -1, aD, 2, 0);
                    AppMethodBeat.o(164801);
                    return;
                }
                com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.dm0));
                AppMethodBeat.o(164801);
            } else {
                if (this.het == 14) {
                    if (NK.getType() == 2 && this.xnQ.xnp.size() != 0) {
                        com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.dm0));
                        AppMethodBeat.o(164801);
                        return;
                    } else if (NK.getType() == 1) {
                        ArrayList<GalleryItem.MediaItem> NJ2 = this.xnQ.NJ(NK.getType());
                        com.tencent.mm.plugin.gallery.model.e.ao(NJ2);
                        Intent intent3 = new Intent(this, ImagePreviewUI.class);
                        intent3.putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                        intent3.putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
                        intent3.putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
                        intent3.putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
                        intent3.putExtra("preview_all", true);
                        intent3.putExtra("preview_position", NJ2.indexOf(NK));
                        az(size, true);
                        intent3.putExtra("send_raw_img", this.qoL);
                        intent3.putExtra("key_force_hide_edit_image_button", this.xoc);
                        intent3.putExtra("key_force_show_raw_image_button", this.xoe);
                        intent3.putExtra("key_is_raw_image_button_disable", this.xof);
                        intent3.putExtra("max_select_count", this.wnd);
                        intent3.putExtra("GalleryUI_FromUser", this.dRL);
                        intent3.putExtra("GalleryUI_ToUser", this.toUser);
                        intent3.putExtra("select_type_tag", this.jVX);
                        startActivityForResult(intent3, 0);
                        AppMethodBeat.o(164801);
                        return;
                    } else if (NK instanceof GalleryItem.VideoMediaItem) {
                        GalleryItem.VideoMediaItem videoMediaItem = (GalleryItem.VideoMediaItem) NK;
                        if (videoMediaItem.jkS <= 2000) {
                            Log.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", Integer.valueOf(videoMediaItem.jkS));
                            h.INSTANCE.n(1005, 53, 1);
                            com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.dmn));
                            AppMethodBeat.o(164801);
                            return;
                        }
                        if (videoMediaItem.videoFrameRate <= 1 && videoMediaItem.videoFrameRate >= 0) {
                            Log.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", Integer.valueOf(videoMediaItem.videoFrameRate), videoMediaItem.xiW);
                            if (videoMediaItem.videoFrameRate <= 1) {
                                try {
                                    String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(videoMediaItem.xiW);
                                    if (!Util.isNullOrNil(simpleMp4InfoVFS)) {
                                        double optDouble = new JSONObject(simpleMp4InfoVFS).optDouble("videoFPS");
                                        Log.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", Double.valueOf(optDouble));
                                        if (optDouble > 0.0d) {
                                            videoMediaItem.videoFrameRate = (int) optDouble;
                                        }
                                    }
                                } catch (Exception e2) {
                                }
                            }
                            if (videoMediaItem.videoFrameRate <= 0) {
                                Log.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", Integer.valueOf(videoMediaItem.videoFrameRate), videoMediaItem.xiW);
                                h.INSTANCE.n(1005, 54, 1);
                                com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.dme));
                                AppMethodBeat.o(164801);
                                return;
                            }
                        }
                        Log.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", Long.valueOf((long) ((getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000) + 500)));
                        Intent intent4 = new Intent();
                        intent4.putExtra("K_SEGMENTVIDEOPATH", videoMediaItem.xiW);
                        intent4.putExtra("KSEGMENTVIDEOTHUMBPATH", videoMediaItem.sUB);
                        setResult(-1, intent4);
                        a.C1384a.xhE.al(NK.xiW, this.jVX, i2);
                        finish();
                        AppMethodBeat.o(164801);
                        return;
                    }
                } else if (this.xog) {
                    int i5 = NK.getType() == 2 ? 1 : this.wnd;
                    if (this.het == 16 && (this.xos == 2 || this.xos == 3)) {
                        if (this.xnQ.xnp.size() <= 0 || this.xnQ.xnp.get(0).getType() == NK.getType()) {
                            i5 = this.wnd;
                        } else {
                            com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.dm0));
                            AppMethodBeat.o(164801);
                            return;
                        }
                    } else if (NK.getType() == 2 && this.xnQ.xnp.size() != 0) {
                        com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.dm0));
                        AppMethodBeat.o(164801);
                        return;
                    }
                    if (this.het == 15 && NK.getType() == 2) {
                        AppMethodBeat.o(164801);
                        return;
                    }
                    ArrayList<GalleryItem.MediaItem> NJ3 = this.xnQ.NJ(NK.getType());
                    com.tencent.mm.plugin.gallery.model.e.ao(NJ3);
                    Intent intent5 = new Intent(this, ImagePreviewUI.class);
                    intent5.putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
                    intent5.putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
                    intent5.putExtra("preview_all", true);
                    intent5.putExtra("preview_position", NJ3.indexOf(NK));
                    az(size, true);
                    intent5.putExtra("send_raw_img", this.qoL);
                    intent5.putExtra("key_force_hide_edit_image_button", this.xoc);
                    intent5.putExtra("key_force_show_raw_image_button", this.xoe);
                    intent5.putExtra("key_is_raw_image_button_disable", this.xof);
                    intent5.putExtra("max_select_count", i5);
                    intent5.putExtra("GalleryUI_FromUser", this.dRL);
                    intent5.putExtra("GalleryUI_ToUser", this.toUser);
                    intent5.putExtra("select_type_tag", this.jVX);
                    intent5.putExtra("album_business_tag", this.xnr);
                    intent5.putExtra("album_video_max_duration", this.kyt);
                    intent5.putExtra("album_video_min_duration", this.xoo);
                    startActivityForResult(intent5, 0);
                    AppMethodBeat.o(164801);
                    return;
                } else {
                    com.tencent.mm.plugin.gallery.model.e.ao(this.xnQ.xno);
                    Intent intent6 = new Intent(this, ImagePreviewUI.class);
                    intent6.putExtra("query_source_type", this.het);
                    intent6.putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
                    intent6.putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
                    intent6.putExtra("preview_all", true);
                    intent6.putExtra("preview_position", size);
                    az(size, true);
                    intent6.putExtra("send_raw_img", this.qoL);
                    intent6.putExtra("key_force_hide_edit_image_button", this.xoc);
                    intent6.putExtra("key_force_show_raw_image_button", this.xoe);
                    intent6.putExtra("key_is_raw_image_button_disable", this.xof);
                    intent6.putExtra("max_select_count", this.wnd);
                    intent6.putExtra("GalleryUI_FromUser", this.dRL);
                    intent6.putExtra("GalleryUI_ToUser", this.toUser);
                    intent6.putExtra("album_business_tag", this.xnr);
                    intent6.putExtra("album_video_max_duration", this.kyt);
                    intent6.putExtra("album_video_min_duration", this.xoo);
                    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 14) {
                        intent6.putExtra("key_edit_video_max_time_length", 300500);
                    }
                    intent6.putExtra("select_type_tag", this.jVX);
                    startActivityForResult(intent6, 0);
                }
                AppMethodBeat.o(164801);
            }
        } else {
            com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.dmt));
            AppMethodBeat.o(164801);
        }
    }

    static /* synthetic */ void d(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(164802);
        if (albumPreviewUI.qoL) {
            Iterator<GalleryItem.MediaItem> it = albumPreviewUI.xnQ.xnp.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                GalleryItem.MediaItem next = it.next();
                if (next != null && next.getType() == 1) {
                    int boW = (int) com.tencent.mm.vfs.s.boW(next.xiW);
                    if (26214400 < boW) {
                        Log.w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", next, Integer.valueOf(boW));
                        i3++;
                    }
                    i2++;
                }
                i2 = i2;
            }
            if (i3 > 0) {
                if (i2 == i3) {
                    com.tencent.mm.ui.base.h.cC(albumPreviewUI, albumPreviewUI.getString(R.string.dmx));
                    AppMethodBeat.o(164802);
                    return;
                }
                com.tencent.mm.ui.base.h.cC(albumPreviewUI, albumPreviewUI.getString(R.string.dmq));
            }
        }
        AppMethodBeat.o(164802);
    }

    static /* synthetic */ String dRZ() {
        return "";
    }

    static /* synthetic */ void f(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(164803);
        if (albumPreviewUI.xnQ.xnp.size() > 0) {
            albumPreviewUI.enableOptionMenu(true);
            AppMethodBeat.o(164803);
            return;
        }
        albumPreviewUI.enableOptionMenu(false);
        AppMethodBeat.o(164803);
    }

    static /* synthetic */ void a(AlbumPreviewUI albumPreviewUI, GalleryItem.MediaItem mediaItem) {
        int boW;
        AppMethodBeat.i(257743);
        if (albumPreviewUI.het == 3 && albumPreviewUI.qoL && 26214400 < (boW = (int) com.tencent.mm.vfs.s.boW(mediaItem.xiW))) {
            Log.w("MicroMsg.AlbumPreviewUI", "[checkRawImageItem] item:%s file size:%s", mediaItem, Integer.valueOf(boW));
            com.tencent.mm.ui.base.h.cC(albumPreviewUI, albumPreviewUI.getString(R.string.dmx));
        }
        AppMethodBeat.o(257743);
    }

    static /* synthetic */ void aO(LinkedList linkedList) {
        GalleryItem.MediaItem next;
        int indexOf;
        AppMethodBeat.i(257744);
        if (linkedList == null) {
            Log.e("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] mMediaItems is null!");
            AppMethodBeat.o(257744);
            return;
        }
        HashSet<GalleryItem.MediaItem> dQN = com.tencent.mm.plugin.gallery.model.e.dQN();
        if (dQN == null || dQN.isEmpty()) {
            Log.i("MicroMsg.AlbumPreviewUI", "editedMediaSet is invalid.");
            AppMethodBeat.o(257744);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] size:%s", Integer.valueOf(linkedList.size()));
        Iterator<GalleryItem.MediaItem> it = dQN.iterator();
        while (it.hasNext() && -1 != (indexOf = linkedList.indexOf((next = it.next())))) {
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) linkedList.get(indexOf);
            if (mediaItem != null && next.mMimeType.equals("edit") && !mediaItem.mMimeType.equals("edit")) {
                Log.d("MicroMsg.AlbumPreviewUI", "item:%s, editItem:%s", mediaItem, next);
                linkedList.set(indexOf, next);
            }
        }
        Log.d("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(257744);
    }

    static /* synthetic */ void D(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(257745);
        Log.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", Integer.valueOf(albumPreviewUI.xoj));
        if (albumPreviewUI.xoh) {
            Log.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
            AppMethodBeat.o(257745);
            return;
        }
        albumPreviewUI.xoj++;
        albumPreviewUI.xoh = true;
        if (albumPreviewUI.xos != 2 && albumPreviewUI.het != 13) {
            if (albumPreviewUI.xos == 1 || albumPreviewUI.xos == 3) {
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKV());
                if (oVar.exists() || oVar.mkdirs()) {
                    boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(albumPreviewUI.getContext(), "android.permission.CAMERA", 16, "", "");
                    Log.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), albumPreviewUI.getContext());
                    if (a2) {
                        albumPreviewUI.dRW();
                    }
                } else {
                    Toast.makeText(albumPreviewUI.getContext(), albumPreviewUI.getString(R.string.dll), 1).show();
                    AppMethodBeat.o(257745);
                    return;
                }
            }
            AppMethodBeat.o(257745);
        } else if (albumPreviewUI.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
            int intExtra = albumPreviewUI.getIntent().getIntExtra("record_video_quality", 0);
            com.tencent.mm.pluginsdk.ui.tools.s.a((Activity) albumPreviewUI.getContext(), albumPreviewUI.getIntent().getStringExtra("video_full_path"), 4372, albumPreviewUI.getIntent().getIntExtra("record_video_time_limit", 0), intExtra, false);
            AppMethodBeat.o(257745);
        } else if (albumPreviewUI.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
            if (((SightParams) albumPreviewUI.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                Log.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
            }
            if (albumPreviewUI.het != 13) {
                com.tencent.mm.pluginsdk.ui.tools.s.a(albumPreviewUI.getContext(), 4375, albumPreviewUI.getIntent(), 3, 1);
                AppMethodBeat.o(257745);
                return;
            }
            RecordConfigProvider eJM = RecordConfigProvider.eJM();
            UICustomParam.a aVar = new UICustomParam.a();
            aVar.apE();
            aVar.apD();
            aVar.dz(true);
            eJM.BOn = aVar.gLU;
            if (albumPreviewUI.qUd) {
                com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(albumPreviewUI.getContext(), 4378, eJM);
                AppMethodBeat.o(257745);
                return;
            }
            com.tencent.mm.pluginsdk.ui.tools.s.a(albumPreviewUI.getContext(), 4375, albumPreviewUI.getIntent(), 4, 1);
            AppMethodBeat.o(257745);
        } else if (ae.gKE.gGI == 2) {
            albumPreviewUI.dRY();
            AppMethodBeat.o(257745);
        } else if (ae.gKE.gGI != 1 || com.tencent.mm.q.a.o(albumPreviewUI.getContext(), true) || com.tencent.mm.q.a.cA(albumPreviewUI.getContext()) || com.tencent.mm.q.a.cE(albumPreviewUI.getContext())) {
            albumPreviewUI.dRY();
            AppMethodBeat.o(257745);
        } else {
            com.tencent.mm.compatible.i.b.w(albumPreviewUI.getContext());
            AppMethodBeat.o(257745);
        }
    }
}
