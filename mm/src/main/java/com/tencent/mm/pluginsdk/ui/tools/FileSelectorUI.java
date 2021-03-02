package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.pluginsdk.ui.tools.DropdownListView;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.AlbumChooserView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 L2\u00020\u0001:\rKLMNOPQRSTUVWB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0014J\b\u0010#\u001a\u00020\u0004H\u0014J \u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020\u0010H\u0016J\b\u00100\u001a\u00020\u0010H\u0002J\"\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020 H\u0014J\u0018\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020 H\u0016J\u001a\u0010D\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\bH\u0002J\u0010\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\nH\u0002J\b\u0010G\u001a\u00020 H\u0002J\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\bH\u0002J\b\u0010J\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MIN_FIRST_PAGE_ITEM_COUNT", "", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "dropdownItemName", "", "dropdownListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "dropdownListView", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "exitMultiTalkListener", "Lcom/tencent/mm/sdk/event/IListener;", "isFirstTextChanged", "", "isSearching", "listView", "Landroid/widget/ListView;", "mIsToScreenProfile", "onItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "scene", "screenProfileReadyUI", "Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "searchMask", "Landroid/view/View;", "searchViewHelper", "Lcom/tencent/mm/ui/tools/SearchViewControlKeyBoardShowHelper;", "toUserName", "doSendFile", "", "finish", "getForceOrientation", "getLayoutId", "goToScreenProfile", "name", "path", "ext", "gotoAppAttachDownloadUI", "msgId", "", "gotoUnDownloadFavDetail", "favLocalId", "favDataId", "initDropdownListTitle", "isActionbarCenterLayoutMode", "isListAtBottom", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "cancel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "openFile", "resetItem", "item", "setDropdownListClickListener", "updateDropdownListTitle", "title", "updateState", "ChattingFileSource", "Companion", "FavFileSource", "FileDataSource", "FileSelectorAdapter", "FileType", "FromType", "ListFavFileItem", "ListFileItem", "ListFolderItem", "ListItem", "ListTimeItem", "SdcardFileSource", "app_release"})
public final class FileSelectorUI extends MMActivity {
    public static final b Kuo = new b((byte) 0);
    private final int Kue = 10;
    private e Kuf;
    private com.tencent.mm.ui.tools.r Kug;
    private View Kuh;
    private String Kui;
    private DropdownListView Kuj;
    private DropdownListView.c Kuk;
    private boolean Kul = true;
    private am Kum;
    private boolean Kun;
    private String dJw;
    private ListView krb;
    private final IListener<?> ndX = new n(this);
    private boolean poG;
    private final AdapterView.OnItemClickListener ppw = new x(this);
    private int scene;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "", "(Ljava/lang/String;I)V", "TYPE_INVALID", "TYPE_TIME", "TYPE_FILE", "TYPE_FOLDER", "app_release"})
    public enum f {
        TYPE_INVALID,
        TYPE_TIME,
        TYPE_FILE,
        TYPE_FOLDER;

        static {
            AppMethodBeat.i(231095);
            AppMethodBeat.o(231095);
        }

        public static f valueOf(String str) {
            AppMethodBeat.i(231097);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(231097);
            return fVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "", "(Ljava/lang/String;I)V", "FROM_CHATTING", "FROM_FAV", "FROM_SDCARD", "app_release"})
    public enum g {
        FROM_CHATTING,
        FROM_FAV,
        FROM_SDCARD;

        static {
            AppMethodBeat.i(231098);
            AppMethodBeat.o(231098);
        }

        public static g valueOf(String str) {
            AppMethodBeat.i(231100);
            g gVar = (g) Enum.valueOf(g.class, str);
            AppMethodBeat.o(231100);
            return gVar;
        }
    }

    static {
        AppMethodBeat.i(231152);
        AppMethodBeat.o(231152);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    public FileSelectorUI() {
        AppMethodBeat.i(231151);
        AppMethodBeat.o(231151);
    }

    public static final /* synthetic */ ListView c(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231153);
        ListView listView = fileSelectorUI.krb;
        if (listView == null) {
            kotlin.g.b.p.btv("listView");
        }
        AppMethodBeat.o(231153);
        return listView;
    }

    public static final /* synthetic */ e d(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231154);
        e eVar = fileSelectorUI.Kuf;
        if (eVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        AppMethodBeat.o(231154);
        return eVar;
    }

    public static final /* synthetic */ void e(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231155);
        fileSelectorUI.dmp();
        AppMethodBeat.o(231155);
    }

    public static final /* synthetic */ void g(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231156);
        fileSelectorUI.Aq(true);
        AppMethodBeat.o(231156);
    }

    public static final /* synthetic */ DropdownListView k(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231159);
        DropdownListView dropdownListView = fileSelectorUI.Kuj;
        if (dropdownListView == null) {
            kotlin.g.b.p.btv("dropdownListView");
        }
        AppMethodBeat.o(231159);
        return dropdownListView;
    }

    public static final /* synthetic */ View r(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231161);
        View contentView = fileSelectorUI.getContentView();
        AppMethodBeat.o(231161);
        return contentView;
    }

    public static final /* synthetic */ void s(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231162);
        fileSelectorUI.gsg();
        AppMethodBeat.o(231162);
    }

    public static final /* synthetic */ void t(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231163);
        fileSelectorUI.gsf();
        AppMethodBeat.o(231163);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$exitMultiTalkListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExitMultiTalkRoomEvent;", "callback", "", "event", "app_release"})
    public static final class n extends IListener<fn> {
        final /* synthetic */ FileSelectorUI Kup;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fn fnVar) {
            AppMethodBeat.i(231120);
            Log.i("MicroMsg.ScreenProfileReadyUI", "exit multi talk room event and remove ");
            AppCompatActivity context = this.Kup.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(231120);
                throw tVar;
            }
            context.finish();
            AppMethodBeat.o(231120);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a8x;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        if (!this.Kun) {
            return 1;
        }
        return 4;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(231139);
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.dJw = getIntent().getStringExtra("TO_USER");
        this.scene = getIntent().getIntExtra("scene", 0);
        gsg();
        setBackBtn(new p(this), R.raw.actionbar_quit_webview_icon);
        if (3 != this.scene) {
            addTextOptionMenu(1, getString(R.string.yq), new q(this), null, t.b.GREEN);
        } else if (!EventCenter.instance.hadListened(this.ndX)) {
            EventCenter.instance.addListener(this.ndX);
        }
        gsf();
        View findViewById = findViewById(R.id.bv5);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.dropdown_list_view)");
        this.Kuj = (DropdownListView) findViewById;
        String string = getString(R.string.cdz);
        kotlin.g.b.p.g(string, "getString(R.string.file_explorer_title_chatting)");
        String string2 = getString(R.string.ce0);
        kotlin.g.b.p.g(string2, "getString(R.string.file_explorer_title_fav)");
        String string3 = getString(R.string.ce1);
        kotlin.g.b.p.g(string3, "getString(R.string.file_explorer_title_local)");
        ArrayList ac = kotlin.a.j.ac(new DropdownListView.c(string, R.raw.icons_outlined_copy, 1), new DropdownListView.c(string2, R.raw.icons_outlined_favorites, 2), new DropdownListView.c(string3, R.raw.icons_outlined_folder, 3));
        DropdownListView dropdownListView = this.Kuj;
        if (dropdownListView == null) {
            kotlin.g.b.p.btv("dropdownListView");
        }
        dropdownListView.setItems(ac);
        DropdownListView dropdownListView2 = this.Kuj;
        if (dropdownListView2 == null) {
            kotlin.g.b.p.btv("dropdownListView");
        }
        dropdownListView2.setListener(new r(this));
        DropdownListView dropdownListView3 = this.Kuj;
        if (dropdownListView3 == null) {
            kotlin.g.b.p.btv("dropdownListView");
        }
        dropdownListView3.setOnItemStateChanged(new s());
        this.Kuf = new e();
        View findViewById2 = findViewById(R.id.cg6);
        if (findViewById2 == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.ListView");
            AppMethodBeat.o(231139);
            throw tVar;
        }
        this.krb = (ListView) findViewById2;
        e eVar = this.Kuf;
        if (eVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        eVar.a(g.FROM_CHATTING);
        ListView listView = this.krb;
        if (listView == null) {
            kotlin.g.b.p.btv("listView");
        }
        e eVar2 = this.Kuf;
        if (eVar2 == null) {
            kotlin.g.b.p.btv("adapter");
        }
        listView.setAdapter((ListAdapter) eVar2);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            kotlin.g.b.p.btv("listView");
        }
        listView2.setOnTouchListener(new t(this));
        ListView listView3 = this.krb;
        if (listView3 == null) {
            kotlin.g.b.p.btv("listView");
        }
        listView3.setOnItemClickListener(this.ppw);
        ListView listView4 = this.krb;
        if (listView4 == null) {
            kotlin.g.b.p.btv("listView");
        }
        listView4.setOnScrollListener(new u(this));
        ListView listView5 = this.krb;
        if (listView5 == null) {
            kotlin.g.b.p.btv("listView");
        }
        if (listView5 == null) {
            kotlin.g.b.p.hyc();
        }
        listView5.setEmptyView(findViewById(R.id.cg0));
        ListView listView6 = this.krb;
        if (listView6 == null) {
            kotlin.g.b.p.btv("listView");
        }
        if (listView6 == null) {
            kotlin.g.b.p.hyc();
        }
        View emptyView = listView6.getEmptyView();
        kotlin.g.b.p.g(emptyView, "listView!!.emptyView");
        emptyView.setVisibility(8);
        this.Kuh = findViewById(R.id.hem);
        View view = this.Kuh;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.Kuh;
        if (view2 != null) {
            view2.setOnClickListener(v.Kvi);
        }
        this.Kug = new com.tencent.mm.ui.tools.r();
        com.tencent.mm.ui.tools.r rVar = this.Kug;
        if (rVar == null) {
            kotlin.g.b.p.hyc();
        }
        rVar.a(new w(this));
        addSearchMenu(true, this.Kug);
        dmp();
        Log.i("MicroMsg.FileSelectorUI", "onCreate, cost:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(231139);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class p implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FileSelectorUI Kup;

        p(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(231123);
            Log.i("MicroMsg.FileSelectorUI", "backBtn");
            FileSelectorUI.g(this.Kup);
            AppMethodBeat.o(231123);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class q implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FileSelectorUI Kup;

        q(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(231124);
            FileSelectorUI.h(this.Kup);
            AppMethodBeat.o(231124);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$3", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"})
    public static final class r implements DropdownListView.d {
        final /* synthetic */ FileSelectorUI Kup;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        r(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.DropdownListView.d
        public final void a(DropdownListView.c cVar) {
            AppMethodBeat.i(231125);
            this.Kup.Kuk = cVar;
            if (cVar != null && !kotlin.g.b.p.j(Util.nullAs(this.Kup.Kui, ""), cVar.name)) {
                switch (cVar.type) {
                    case 1:
                        e d2 = FileSelectorUI.d(this.Kup);
                        if (d2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        d2.a(g.FROM_CHATTING);
                        break;
                    case 2:
                        e d3 = FileSelectorUI.d(this.Kup);
                        if (d3 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        d3.a(g.FROM_FAV);
                        break;
                    case 3:
                        e d4 = FileSelectorUI.d(this.Kup);
                        if (d4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        d4.a(g.FROM_SDCARD);
                        break;
                }
            } else {
                Log.w("MicroMsg.FileSelectorUI", "want to reset item, item is " + cVar + " or no need load data when same load");
            }
            if (this.Kup.Kuk != null) {
                FileSelectorUI fileSelectorUI = this.Kup;
                DropdownListView.c cVar2 = this.Kup.Kuk;
                if (cVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                FileSelectorUI.b(fileSelectorUI, cVar2);
            }
            FileSelectorUI.k(this.Kup).dSg();
            AppMethodBeat.o(231125);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$4", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "onItemStateChanged", "", "expanded", "", "app_release"})
    public static final class s implements DropdownListView.e {
        s() {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    static final class t implements View.OnTouchListener {
        final /* synthetic */ FileSelectorUI Kup;

        t(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(231126);
            this.Kup.hideVKB();
            AppMethodBeat.o(231126);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$6", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "app_release"})
    public static final class u implements AbsListView.OnScrollListener {
        final /* synthetic */ FileSelectorUI Kup;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        u(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(231127);
            kotlin.g.b.p.h(absListView, "view");
            if (this.Kup.poG) {
                Log.i("MicroMsg.FileSelectorUI", "search mode, not load data");
                AppMethodBeat.o(231127);
                return;
            }
            if (i2 == 0 && FileSelectorUI.m(this.Kup)) {
                Log.i("MicroMsg.FileSelectorUI", "will load data when it at bottom");
                e d2 = FileSelectorUI.d(this.Kup);
                switch (f.vkf[d2.KuB.ordinal()]) {
                    case 1:
                        d2.Kuy.gsk();
                        AppMethodBeat.o(231127);
                        return;
                    case 2:
                        d2.Kuz.gsk();
                        break;
                }
            }
            AppMethodBeat.o(231127);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AppMethodBeat.i(231128);
            kotlin.g.b.p.h(absListView, "view");
            AppMethodBeat.o(231128);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class v implements View.OnClickListener {
        public static final v Kvi = new v();

        static {
            AppMethodBeat.i(231130);
            AppMethodBeat.o(231130);
        }

        v() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(231129);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231129);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$8", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "app_release"})
    public static final class w implements s.b {
        final /* synthetic */ FileSelectorUI Kup;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        w(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void SO(String str) {
            View view;
            AppMethodBeat.i(231132);
            kotlin.g.b.p.h(str, "searchText");
            if (!this.Kup.Kul && (view = this.Kup.Kuh) != null) {
                view.setVisibility(8);
            }
            FileSelectorUI.d(this.Kup).DO(str);
            this.Kup.Kul = false;
            AppMethodBeat.o(231132);
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final boolean SN(String str) {
            AppMethodBeat.i(231133);
            kotlin.g.b.p.h(str, "searchText");
            AppMethodBeat.o(231133);
            return false;
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bny() {
            AppMethodBeat.i(231134);
            this.Kup.poG = false;
            Log.d("MicroMsg.FileSelectorUI", "onQuitSearch()");
            MMHandlerThread.postToMainThread(new a(this));
            this.Kup.getController().supportInvalidateOptionsMenu();
            View view = this.Kup.Kuh;
            if (view != null) {
                view.setVisibility(8);
                AppMethodBeat.o(231134);
                return;
            }
            AppMethodBeat.o(231134);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ w Kvj;

            a(w wVar) {
                this.Kvj = wVar;
            }

            public final void run() {
                AppMethodBeat.i(231131);
                if (FileSelectorUI.d(this.Kvj.Kup) != null) {
                    FileSelectorUI.d(this.Kvj.Kup).DO("");
                }
                AppMethodBeat.o(231131);
            }
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bnz() {
            DropdownListView k;
            AppMethodBeat.i(231135);
            if (FileSelectorUI.k(this.Kup).qkb && (k = FileSelectorUI.k(this.Kup)) != null) {
                k.dSg();
            }
            this.Kup.poG = true;
            View view = this.Kup.Kuh;
            if (view != null) {
                view.setVisibility(0);
            }
            com.tencent.mm.ui.tools.r rVar = this.Kup.Kug;
            if (rVar != null) {
                rVar.CJ(true);
            }
            Log.i("MicroMsg.FileSelectorUI", "enter search");
            AppMethodBeat.o(231135);
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bnA() {
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bnB() {
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final boolean isActionbarCenterLayoutMode() {
        return false;
    }

    private final void bm(String str, String str2, String str3) {
        AppMethodBeat.i(231140);
        com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
        kotlin.g.b.p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom.emr()) {
            setMMTitle(str);
            hideActionBarOperationArea();
            removeSearchMenu();
            setBackBtn(new o(this), R.raw.actionbar_icon_dark_back);
            this.Kun = true;
            DropdownListView dropdownListView = this.Kuj;
            if (dropdownListView == null) {
                kotlin.g.b.p.btv("dropdownListView");
            }
            if (dropdownListView != null) {
                dropdownListView.setVisibility(4);
            }
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            this.Kum = new am(context, str2, str3);
            am amVar = this.Kum;
            if (amVar == null) {
                kotlin.g.b.p.hyc();
            }
            String str4 = amVar.filePath;
            String str5 = amVar.gCr;
            kotlin.g.b.p.h(str4, "filePath");
            kotlin.g.b.p.h(str5, "fileExt");
            File file = new File(str4);
            if (file.exists() && file.isFile()) {
                HashMap hashMap = new HashMap();
                hashMap.put("extra_param_disable_scale", "false");
                hashMap.put("extra_param_bg_color", String.valueOf(Color.parseColor("#ededed")));
                hashMap.put("extra_param_disable_finish_activity", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                hashMap.put("extra_param_set_max_scale", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                hashMap.put("extra_param_download_text_color", "-16777216");
                String valueOf = String.valueOf(((long) amVar.hashCode()) + System.currentTimeMillis());
                h.c cVar = h.c.ReaderView;
                Context context2 = amVar.getContext();
                if (context2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(231140);
                    throw tVar;
                }
                Activity activity = (Activity) context2;
                RelativeLayout relativeLayout = amVar.Pko;
                if (relativeLayout == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(231140);
                    throw tVar2;
                }
                com.tencent.xweb.h.a(str4, str5, valueOf, true, (HashMap<String, String>) hashMap, cVar, activity, (ViewGroup) relativeLayout, (h.a) new am.b(amVar), (ValueCallback<Integer>) new am.c(amVar));
            }
            View contentView = getContentView();
            if (contentView == null) {
                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(231140);
                throw tVar3;
            }
            ((ViewGroup) contentView).addView(this.Kum);
            setRequestedOrientation(4);
        }
        AppMethodBeat.o(231140);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class o implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FileSelectorUI Kup;

        o(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(231122);
            Log.i("MicroMsg.FileSelectorUI", "backBtn");
            am amVar = this.Kup.Kum;
            if (amVar != null) {
                amVar.removeAllViews();
            }
            View r = FileSelectorUI.r(this.Kup);
            if (r == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(231122);
                throw tVar;
            }
            ((ViewGroup) r).removeView(this.Kup.Kum);
            this.Kup.setBackBtn(new MenuItem.OnMenuItemClickListener(this) {
                /* class com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.o.AnonymousClass1 */
                final /* synthetic */ o Kvh;

                {
                    this.Kvh = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(231121);
                    Log.i("MicroMsg.FileSelectorUI", "backBtn");
                    FileSelectorUI.g(this.Kvh.Kup);
                    AppMethodBeat.o(231121);
                    return false;
                }
            }, R.raw.actionbar_quit_webview_icon);
            DropdownListView k = FileSelectorUI.k(this.Kup);
            if (k != null) {
                k.setVisibility(0);
            }
            FileSelectorUI.s(this.Kup);
            FileSelectorUI.t(this.Kup);
            this.Kup.setRequestedOrientation(1);
            this.Kup.addSearchMenu(true, this.Kup.Kug);
            this.Kup.Kun = false;
            com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
            com.tencent.mm.plugin.multitalk.d.f.eql();
            AppMethodBeat.o(231122);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(231141);
        kotlin.g.b.p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (this.Kun && this.Kum != null) {
            am amVar = this.Kum;
            if (amVar == null) {
                kotlin.g.b.p.hyc();
            }
            amVar.gOo();
            amVar.gOn();
        }
        AppMethodBeat.o(231141);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"})
    static final class x implements AdapterView.OnItemClickListener {
        final /* synthetic */ FileSelectorUI Kup;

        x(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(231136);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            e d2 = FileSelectorUI.d(this.Kup);
            if (d2 == null) {
                kotlin.g.b.p.hyc();
            }
            k aiR = d2.aiR(i2);
            if (this.Kup.Kun) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(231136);
                return;
            }
            switch (g.$EnumSwitchMapping$0[aiR.KuY.ordinal()]) {
                case 1:
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(231136);
                    return;
                case 2:
                    if (aiR != null) {
                        j jVar = (j) aiR;
                        if (!jVar.KuX) {
                            if (!Util.isNullOrNil(jVar.filePath)) {
                                e d3 = FileSelectorUI.d(this.Kup);
                                String str = jVar.filePath;
                                if (str == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                kotlin.g.b.p.h(str, "path");
                                if (d3.KuB == g.FROM_SDCARD) {
                                    d3.KuA.ad(new com.tencent.mm.vfs.o(str));
                                    FileSelectorUI.d(FileSelectorUI.this).bqe();
                                }
                                FileSelectorUI.d(this.Kup).notifyDataSetChanged();
                                break;
                            } else {
                                Log.e("MicroMsg.FileSelectorUI", "can not open sub path because current path not exist");
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(231136);
                                return;
                            }
                        } else {
                            FileSelectorUI.a(this.Kup, jVar.filePath, jVar.gsq().toString());
                            break;
                        }
                    } else {
                        try {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFolderItem");
                            AppMethodBeat.o(231136);
                            throw tVar;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.FileSelectorUI", "error:" + e2.getMessage());
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(231136);
                            return;
                        }
                    }
                case 3:
                    if (aiR == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
                        AppMethodBeat.o(231136);
                        throw tVar2;
                    }
                    String str2 = ((i) aiR).filePath;
                    int g2 = kotlin.n.n.g(((i) aiR).gsq(), ".") + 1;
                    if (g2 >= ((i) aiR).gsq().length()) {
                        Log.i("MicroMsg.FileSelectorUI", "open file error : file path error");
                        com.tencent.mm.ui.base.u.cH(this.Kup, this.Kup.getResources().getString(R.string.gep));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(231136);
                        return;
                    }
                    CharSequence gsq = ((i) aiR).gsq();
                    String obj = gsq.subSequence(g2, gsq.length()).toString();
                    if (3 == this.Kup.scene && !((i) aiR).KuV && g.FROM_CHATTING == FileSelectorUI.d(this.Kup).KuB) {
                        if (kotlin.n.n.I(obj, "ppt", true) || kotlin.n.n.I(obj, "pdf", true) || kotlin.n.n.I(obj, "doc", true) || kotlin.n.n.I(obj, "docx", true) || kotlin.n.n.I(obj, "pptx", true)) {
                            FileSelectorUI.a(this.Kup, ((i) aiR).msgId);
                        } else {
                            com.tencent.mm.ui.base.u.cH(this.Kup, this.Kup.getResources().getString(R.string.gep));
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(231136);
                        return;
                    } else if (g.FROM_FAV != FileSelectorUI.d(this.Kup).KuB || com.tencent.mm.vfs.s.YS(((i) aiR).filePath)) {
                        FileSelectorUI.a(this.Kup, str2, ((i) aiR).gsq().toString());
                        break;
                    } else {
                        h hVar = (h) aiR;
                        FileSelectorUI.a(this.Kup, hVar.localId, hVar.gsp());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(231136);
                        return;
                    }
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(231136);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(231142);
        super.onPause();
        if (!isFinishing() && !isDestroyed()) {
            DropdownListView dropdownListView = this.Kuj;
            if (dropdownListView == null) {
                kotlin.g.b.p.btv("dropdownListView");
            }
            if (dropdownListView != null) {
                DropdownListView dropdownListView2 = this.Kuj;
                if (dropdownListView2 == null) {
                    kotlin.g.b.p.btv("dropdownListView");
                }
                if (dropdownListView2 == null) {
                    kotlin.g.b.p.hyc();
                }
                if (dropdownListView2.qkb) {
                    DropdownListView dropdownListView3 = this.Kuj;
                    if (dropdownListView3 == null) {
                        kotlin.g.b.p.btv("dropdownListView");
                    }
                    if (dropdownListView3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (!dropdownListView3.qkb) {
                        Log.w("MicroMsg.DropdownListView", "want to close, but it was closed");
                        AppMethodBeat.o(231142);
                        return;
                    } else if (dropdownListView3.xpW) {
                        Log.d("MicroMsg.DropdownListView", "want to close, but it is in animation");
                        AppMethodBeat.o(231142);
                        return;
                    } else {
                        FrameLayout frameLayout = dropdownListView3.xpS;
                        if (frameLayout == null) {
                            kotlin.g.b.p.hyc();
                        }
                        frameLayout.setVisibility(8);
                        dropdownListView3.qkb = false;
                        if (dropdownListView3.KtA != null && dropdownListView3.KtA == null) {
                            kotlin.g.b.p.hyc();
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(231142);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(231143);
        super.finish();
        e eVar = this.Kuf;
        if (eVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        eVar.Kuy.gsh();
        AppMethodBeat.o(231143);
    }

    private final void gsf() {
        AppMethodBeat.i(231144);
        initActionBarOperationArea();
        initActionBarOperationAreaTxt(getString(R.string.cdz), R.color.FG_0, R.color.FG_0, R.drawable.wv, R.drawable.wu);
        AppMethodBeat.o(231144);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onAlbumChooserViewClick"})
    public static final class z implements AlbumChooserView.a {
        final /* synthetic */ FileSelectorUI Kup;

        z(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        @Override // com.tencent.mm.ui.widget.AlbumChooserView.a
        public final void dSb() {
            AppMethodBeat.i(231138);
            Log.i("MicroMsg.FileSelectorUI", "onAlbumChooserViewClick.");
            this.Kup.Kuk = null;
            this.Kup.playActionBarOperationAreaAnim();
            DropdownListView k = FileSelectorUI.k(this.Kup);
            if (k == null) {
                kotlin.g.b.p.hyc();
            }
            k.dSg();
            AppMethodBeat.o(231138);
        }
    }

    private final void gsg() {
        AppMethodBeat.i(231145);
        setActionBarOperationAreaClickListener(new z(this));
        AppMethodBeat.o(231145);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(231146);
        super.onDestroy();
        EventCenter.instance.removeListener(this.ndX);
        com.tencent.mm.ui.tools.r rVar = this.Kug;
        if (rVar != null) {
            rVar.gXP();
            AppMethodBeat.o(231146);
            return;
        }
        AppMethodBeat.o(231146);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(231147);
        kotlin.g.b.p.h(keyEvent, "event");
        if (i2 == 4) {
            Log.i("MicroMsg.FileSelectorUI", "onKeyDown back");
            if (this.Kun) {
                am amVar = this.Kum;
                if (amVar != null) {
                    amVar.removeAllViews();
                }
                View contentView = getContentView();
                if (contentView == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(231147);
                    throw tVar;
                }
                ((ViewGroup) contentView).removeView(this.Kum);
                setBackBtn(new y(this), R.raw.actionbar_quit_webview_icon);
                DropdownListView dropdownListView = this.Kuj;
                if (dropdownListView == null) {
                    kotlin.g.b.p.btv("dropdownListView");
                }
                if (dropdownListView != null) {
                    dropdownListView.setVisibility(0);
                }
                gsg();
                gsf();
                setRequestedOrientation(1);
                addSearchMenu(true, this.Kug);
                com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
                com.tencent.mm.plugin.multitalk.d.f.eql();
                this.Kun = false;
            } else {
                Aq(false);
            }
            AppMethodBeat.o(231147);
            return true;
        } else if (i2 == 82) {
            DropdownListView dropdownListView2 = this.Kuj;
            if (dropdownListView2 == null) {
                kotlin.g.b.p.btv("dropdownListView");
            }
            if (dropdownListView2 != null) {
                DropdownListView dropdownListView3 = this.Kuj;
                if (dropdownListView3 == null) {
                    kotlin.g.b.p.btv("dropdownListView");
                }
                if (dropdownListView3 == null) {
                    kotlin.g.b.p.hyc();
                }
                dropdownListView3.dSg();
            }
            AppMethodBeat.o(231147);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(231147);
            return onKeyDown;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class y implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FileSelectorUI Kup;

        y(FileSelectorUI fileSelectorUI) {
            this.Kup = fileSelectorUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(231137);
            Log.i("MicroMsg.FileSelectorUI", "onKeyDown, go back");
            FileSelectorUI.g(this.Kup);
            AppMethodBeat.o(231137);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(231148);
        if (i2 != 4 || intent == null) {
            if (!(i2 == 0 && i3 == -1) && i2 == 2) {
                a.a((Activity) this, i2, i3, intent, true, (int) R.string.bny, (int) R.string.bnz, 1);
                com.tencent.mm.ui.base.u.makeText(this, (int) R.string.cdr, 0).show();
            }
            AppMethodBeat.o(231148);
            return;
        }
        String stringExtra = intent.getStringExtra("filePath");
        String stringExtra2 = intent.getStringExtra(DownloadInfo.FILENAME);
        String stringExtra3 = intent.getStringExtra("fileExt");
        if (kotlin.n.n.I(stringExtra3, "ppt", true) || kotlin.n.n.I(stringExtra3, "pdf", true) || kotlin.n.n.I(stringExtra3, "doc", true) || kotlin.n.n.I(stringExtra3, "docx", true) || kotlin.n.n.I(stringExtra3, "pptx", true)) {
            if (stringExtra2 == null) {
                kotlin.g.b.p.hyc();
            }
            if (stringExtra == null) {
                kotlin.g.b.p.hyc();
            }
            if (stringExtra3 == null) {
                kotlin.g.b.p.hyc();
            }
            bm(stringExtra2, stringExtra, stringExtra3);
            AppMethodBeat.o(231148);
        } else if (intent.getBooleanExtra("resLoadFailed", false)) {
            com.tencent.mm.ui.base.u.cH(this, getResources().getString(R.string.ce2));
            AppMethodBeat.o(231148);
        } else {
            com.tencent.mm.ui.base.u.cH(this, getResources().getString(R.string.gep));
            AppMethodBeat.o(231148);
        }
    }

    private final void Aq(boolean z2) {
        AppMethodBeat.i(231149);
        DropdownListView dropdownListView = this.Kuj;
        if (dropdownListView == null) {
            kotlin.g.b.p.btv("dropdownListView");
        }
        if (dropdownListView != null) {
            DropdownListView dropdownListView2 = this.Kuj;
            if (dropdownListView2 == null) {
                kotlin.g.b.p.btv("dropdownListView");
            }
            if (dropdownListView2 == null) {
                kotlin.g.b.p.hyc();
            }
            if (dropdownListView2.qkb) {
                DropdownListView dropdownListView3 = this.Kuj;
                if (dropdownListView3 == null) {
                    kotlin.g.b.p.btv("dropdownListView");
                }
                if (dropdownListView3 == null) {
                    kotlin.g.b.p.hyc();
                }
                dropdownListView3.dSg();
                playActionBarOperationAreaAnim();
            }
        }
        if (!z2) {
            e eVar = this.Kuf;
            if (eVar == null) {
                kotlin.g.b.p.btv("adapter");
            }
            if (eVar.gsn() != null) {
                e eVar2 = this.Kuf;
                if (eVar2 == null) {
                    kotlin.g.b.p.btv("adapter");
                }
                eVar2.gsm();
                e eVar3 = this.Kuf;
                if (eVar3 == null) {
                    kotlin.g.b.p.btv("adapter");
                }
                eVar3.notifyDataSetChanged();
                AppMethodBeat.o(231149);
                return;
            }
        }
        setResult(-2);
        if (z2) {
            setResult(0);
        }
        finish();
        AppMethodBeat.o(231149);
    }

    private final void dmp() {
        AppMethodBeat.i(231150);
        e eVar = this.Kuf;
        if (eVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        if (eVar == null) {
            kotlin.g.b.p.hyc();
        }
        int size = eVar.Kux.size();
        if (3 != this.scene) {
            if (size > 0) {
                updateOptionMenuText(1, getString(R.string.yq).toString() + "(" + size + "/9)");
                enableOptionMenu(1, true);
                AppMethodBeat.o(231150);
                return;
            }
            updateOptionMenuText(1, getString(R.string.yq));
            enableOptionMenu(1, false);
        }
        AppMethodBeat.o(231150);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "from", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "getFrom", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "setFrom", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "getType", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "setType", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;)V", "app_release"})
    public class k {
        f KuY = f.TYPE_INVALID;
        public g KuZ;
        String title;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public k() {
        }

        public final void a(f fVar) {
            AppMethodBeat.i(231104);
            kotlin.g.b.p.h(fVar, "<set-?>");
            this.KuY = fVar;
            AppMethodBeat.o(231104);
        }

        public final void d(g gVar) {
            AppMethodBeat.i(231106);
            kotlin.g.b.p.h(gVar, "<set-?>");
            this.KuZ = gVar;
            AppMethodBeat.o(231106);
        }

        public final g gsr() {
            AppMethodBeat.i(231105);
            g gVar = this.KuZ;
            if (gVar == null) {
                kotlin.g.b.p.btv("from");
            }
            AppMethodBeat.o(231105);
            return gVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListTimeItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "app_release"})
    public final class l extends k {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public l() {
            super();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010*\u001a\u00060\u0000R\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001a\u0010'\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006+"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "displayFromUser", "", "getDisplayFromUser", "()Ljava/lang/CharSequence;", "setDisplayFromUser", "(Ljava/lang/CharSequence;)V", "fileLen", "", "getFileLen", "()I", "setFileLen", "(I)V", DownloadInfo.FILENAME, "getFileName", "setFileName", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isDownloaded", "", "()Z", "setDownloaded", "(Z)V", "legalType", "getLegalType", "setLegalType", "msgId", "getMsgId", "setMsgId", "clone", "app_release"})
    public class i extends k {
        CharSequence KuS;
        public CharSequence KuT;
        int KuU;
        boolean KuV;
        long createTime;
        String filePath;
        long msgId;
        int zGp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public i() {
            super();
        }

        public final void am(CharSequence charSequence) {
            AppMethodBeat.i(231103);
            kotlin.g.b.p.h(charSequence, "<set-?>");
            this.KuT = charSequence;
            AppMethodBeat.o(231103);
        }

        public final CharSequence gsq() {
            AppMethodBeat.i(231102);
            CharSequence charSequence = this.KuT;
            if (charSequence == null) {
                kotlin.g.b.p.btv(DownloadInfo.FILENAME);
            }
            AppMethodBeat.o(231102);
            return charSequence;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFavFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "cdnDataUrl", "", "getCdnDataUrl", "()Ljava/lang/String;", "setCdnDataUrl", "(Ljava/lang/String;)V", "dataId", "getDataId", "setDataId", "desc", "getDesc", "setDesc", "favTitle", "getFavTitle", "setFavTitle", ch.COL_LOCALID, "", "getLocalId", "()J", "setLocalId", "(J)V", "app_release"})
    public class h extends i {
        String KuQ;
        String KuR;
        public String dLl;
        String desc;
        long localId;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public h() {
            super();
        }

        public final String gsp() {
            AppMethodBeat.i(231101);
            String str = this.dLl;
            if (str == null) {
                kotlin.g.b.p.btv("dataId");
            }
            AppMethodBeat.o(231101);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFolderItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "isFile", "", "()Z", "setFile", "(Z)V", "subFilesCnt", "", "getSubFilesCnt", "()I", "setSubFilesCnt", "(I)V", "app_release"})
    public final class j extends i {
        int KuW;
        boolean KuX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public j() {
            super();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b¦\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010%\u001a\f\u0012\b\u0012\u00060\u0010R\u00020\u00040\u000fJ\u0012\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010 H\u0004J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020)H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020-H&J\u001a\u0010/\u001a\f\u0012\b\u0012\u00060\u0010R\u00020\u00040\u000f2\b\u0010*\u001a\u0004\u0018\u00010 R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0010R\u00020\u00040\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0010R\u00020\u00040\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00060"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "DEFAULT_PAGESIZE", "", "getDEFAULT_PAGESIZE", "()I", "setDEFAULT_PAGESIZE", "(I)V", "getAdapter", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getFileList", "()Ljava/util/List;", "setFileList", "(Ljava/util/List;)V", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "searchList", "startIndex", "getStartIndex", "setStartIndex", "talker", "", "getTalker", "()Ljava/lang/String;", "setTalker", "(Ljava/lang/String;)V", "getData", "getDisplayName", "fromUser", "getHighLightContent", "", "key", "content", "initASync", "", "loadMoreAsync", "search", "app_release"})
    public abstract class d {
        final e Kuf;
        final /* synthetic */ FileSelectorUI Kup;
        int Kut = 100;
        List<i> Kuu;
        private List<i> Kuv;
        boolean hasInit;
        int startIndex;
        String talker;

        public d(FileSelectorUI fileSelectorUI, e eVar) {
            kotlin.g.b.p.h(eVar, "adapter");
            this.Kup = fileSelectorUI;
            this.Kuf = eVar;
            List<i> synchronizedList = Collections.synchronizedList(new ArrayList());
            kotlin.g.b.p.g(synchronizedList, "Collections.synchronized…rrayList<ListFileItem>())");
            this.Kuu = synchronizedList;
            List<i> synchronizedList2 = Collections.synchronizedList(new ArrayList());
            kotlin.g.b.p.g(synchronizedList2, "Collections.synchronized…rrayList<ListFileItem>())");
            this.Kuv = synchronizedList2;
            String aTY = com.tencent.mm.model.z.aTY();
            kotlin.g.b.p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            this.talker = aTY;
        }

        private static CharSequence a(String str, CharSequence charSequence) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(charSequence);
            int a2 = kotlin.n.n.a(charSequence, str, 0, true);
            spannableString.setSpan(new ForegroundColorSpan(b.C1383b.wZQ), a2, str.length() + a2, 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            return spannableStringBuilder;
        }

        /* access modifiers changed from: protected */
        public final String getDisplayName(String str) {
            String str2;
            String aTY = com.tencent.mm.model.z.aTY();
            if (Util.isNullOrNil(str) || kotlin.g.b.p.j(str, aTY)) {
                str2 = this.Kup.getString(R.string.f_e);
            } else {
                str2 = aa.getDisplayName(str);
            }
            String string = this.Kup.getString(R.string.b2s, new Object[]{str2});
            kotlin.g.b.p.g(string, "getString(R.string.chatt…ce_from, displayFromUser)");
            return string;
        }

        public final List<i> bfx(String str) {
            String str2;
            this.Kuv.clear();
            if (Util.isNullOrNil(str)) {
                for (i iVar : this.Kuu) {
                    iVar.KuS = String.valueOf(iVar.KuS);
                    iVar.am(iVar.gsq().toString());
                    i iVar2 = new i();
                    iVar2.a(iVar.KuY);
                    iVar2.title = iVar.title;
                    iVar2.d(iVar.gsr());
                    iVar2.msgId = iVar.msgId;
                    iVar2.createTime = iVar.createTime;
                    iVar2.KuS = iVar.KuS;
                    CharSequence charSequence = iVar.KuT;
                    if (charSequence == null) {
                        kotlin.g.b.p.btv(DownloadInfo.FILENAME);
                    }
                    iVar2.KuT = charSequence;
                    iVar2.filePath = iVar.filePath;
                    iVar2.zGp = iVar.zGp;
                    iVar2.KuU = iVar.KuU;
                    iVar2.KuV = iVar.KuV;
                    this.Kuv.add(iVar2);
                }
            } else {
                for (i iVar3 : this.Kuu) {
                    CharSequence charSequence2 = iVar3.KuS;
                    if (charSequence2 != null) {
                        str2 = charSequence2;
                    }
                    CharSequence gsq = iVar3.gsq();
                    if (str == null) {
                        kotlin.g.b.p.hyc();
                    }
                    boolean a2 = kotlin.n.n.a(gsq, (CharSequence) str, true);
                    boolean a3 = kotlin.n.n.a(str2, (CharSequence) str, true);
                    if (a2 || a3) {
                        if (a2) {
                            iVar3.am(a(str, iVar3.gsq()));
                        }
                        if (a3) {
                            iVar3.KuS = a(str, str2);
                        }
                        this.Kuv.add(iVar3);
                    }
                }
            }
            return this.Kuv;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u00022\u00020\u0003B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u0010\u0019\u001a\u00020\u000fJ\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgIdList", "", "", "searchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "appendFileList", "", "msgInfoList", "", "Lcom/tencent/mm/storage/MsgInfo;", "asyncLoad", "cancelSearchTask", "coreLoad", "createFileListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "msgInfo", "finish", "getAllAppMsgFileId", "getAttachPathSimple", "", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "getQuery", "initASync", "isAppMsgFileDownloaded", "", "loadDataAndShow", "loadMoreAsync", "onFTSSearchEnd", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "app_release"})
    public final class a extends d implements com.tencent.mm.plugin.fts.a.l {
        final /* synthetic */ FileSelectorUI Kup;
        final MMHandler handler = new MMHandler();
        com.tencent.mm.plugin.fts.a.a.a wXa;
        private final List<Long> xEG = new ArrayList();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FileSelectorUI fileSelectorUI, e eVar) {
            super(fileSelectorUI, eVar);
            kotlin.g.b.p.h(eVar, "adapter");
            this.Kup = fileSelectorUI;
            AppMethodBeat.i(231053);
            AppMethodBeat.o(231053);
        }

        /* access modifiers changed from: package-private */
        public final void gsh() {
            AppMethodBeat.i(231046);
            if (this.wXa != null) {
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.wXa);
            }
            AppMethodBeat.o(231046);
        }

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(231047);
            kotlin.g.b.p.h(kVar, "ftsResult");
            switch (kVar.resultCode) {
                case -3:
                case -2:
                case -1:
                    Log.e("MicroMsg.FileSelectorUI", "get msgId fail, errorCode:" + kVar.resultCode);
                    break;
                case 0:
                    Log.i("MicroMsg.FileSelectorUI", "onFTSSearchEnd, size:" + kVar.wXb.size());
                    for (com.tencent.mm.plugin.fts.a.a.m mVar : kVar.wXb) {
                        this.xEG.add(Long.valueOf(mVar.wXe));
                        Log.d("MicroMsg.FileSelectorUI", "msgId:" + mVar.wXe);
                    }
                    break;
            }
            gsj();
            AppMethodBeat.o(231047);
        }

        /* access modifiers changed from: package-private */
        public final void gsj() {
            AppMethodBeat.i(231049);
            gsi();
            com.tencent.mm.ac.d.h(new b(this));
            AppMethodBeat.o(231049);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI$a$a  reason: collision with other inner class name */
        public static final class RunnableC2032a implements Runnable {
            final /* synthetic */ a Kuq;

            RunnableC2032a(a aVar) {
                this.Kuq = aVar;
            }

            public final void run() {
                AppMethodBeat.i(231044);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = this.Kuq.hasInit;
                if (!this.Kuq.hasInit) {
                    this.Kuq.hasInit = true;
                    a aVar = this.Kuq;
                    aVar.gsh();
                    com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                    jVar.query = "query_app_msg_file";
                    jVar.wWS = null;
                    jVar.wWV = new int[]{42};
                    jVar.wWZ = aVar;
                    jVar.handler = aVar.handler;
                    jVar.kXb = 256;
                    aVar.wXa = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(3, jVar);
                    Log.i("MicroMsg.FileSelectorUI", "do search %s", "query_app_msg_file");
                } else {
                    this.Kuq.gsj();
                }
                Log.i("MicroMsg.FileSelectorUI", "[isInit:" + z + "] chatting load data end:" + (System.currentTimeMillis() - currentTimeMillis) + ", startIndex:" + this.Kuq.startIndex);
                AppMethodBeat.o(231044);
            }
        }

        /* access modifiers changed from: package-private */
        public final void gsk() {
            AppMethodBeat.i(231050);
            com.tencent.f.h.RTc.aX(new RunnableC2032a(this));
            AppMethodBeat.o(231050);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ff  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void iw(java.util.List<? extends com.tencent.mm.storage.ca> r11) {
            /*
            // Method dump skipped, instructions count: 301
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.a.iw(java.util.List):void");
        }

        private final void gsi() {
            int i2;
            AppMethodBeat.i(231048);
            int size = this.Kuu.size();
            while (this.Kuu.size() - size < this.Kup.Kue) {
                ArrayList<Long> arrayList = new ArrayList<>();
                if (this.startIndex + this.Kut > this.xEG.size()) {
                    i2 = this.xEG.size();
                } else {
                    i2 = this.startIndex + this.Kut;
                }
                if (i2 <= this.startIndex) {
                    Log.i("MicroMsg.FileSelectorUI", "coreLoad, not data to load, " + i2 + " < " + this.startIndex);
                    AppMethodBeat.o(231048);
                    return;
                }
                Log.i("MicroMsg.FileSelectorUI", "coreLoad, startIndex:" + this.startIndex + ", endIndex:" + i2 + ", totalCnt:" + this.xEG.size() + ", PageSize:" + this.Kut);
                for (int i3 = this.startIndex; i3 < i2; i3++) {
                    arrayList.add(this.xEG.get(i3));
                }
                kotlin.g.b.p.g(bg.aVF(), "MMCore.getAccStg()");
                List<ca> k = com.tencent.mm.model.c.aSQ().k(this.talker, arrayList);
                this.startIndex += this.Kut;
                if (k.size() == 0) {
                    AppMethodBeat.o(231048);
                    return;
                } else {
                    kotlin.g.b.p.g(k, "msgInfoList");
                    iw(k);
                }
            }
            AppMethodBeat.o(231048);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ a Kuq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(0);
                this.Kuq = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(231045);
                this.Kuq.Kuf.bqe();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(231045);
                return xVar;
            }
        }

        public final void gsl() {
            AppMethodBeat.i(231051);
            this.hasInit = false;
            this.startIndex = 0;
            this.Kut = 30;
            gsk();
            AppMethodBeat.o(231051);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FavFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "appendFileList", "", "listFavItem", "", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "asyncLoad", "canBeForwardWithMsg", "", "info", "coreLoad", "", "createFileListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "favItemInfo", "getAllFavItemInfoInCurType", "subList", "dataType", "itemType", "initASync", "loadMoreAsync", "app_release"})
    public final class c extends d {
        final /* synthetic */ FileSelectorUI Kup;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FileSelectorUI fileSelectorUI, e eVar) {
            super(fileSelectorUI, eVar);
            kotlin.g.b.p.h(eVar, "adapter");
            this.Kup = fileSelectorUI;
            AppMethodBeat.i(231061);
            AppMethodBeat.o(231061);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class a implements Runnable {
            final /* synthetic */ c Kur;

            a(c cVar) {
                this.Kur = cVar;
            }

            public final void run() {
                AppMethodBeat.i(231056);
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = this.Kur.hasInit;
                if (!this.Kur.hasInit) {
                    this.Kur.hasInit = true;
                    while (true) {
                        if (this.Kur.Kuu.size() < this.Kur.Kup.Kue) {
                            if (c.a(this.Kur) <= 0) {
                                Log.i("MicroMsg.FileSelectorUI", "has no data to load，chatting init sync end:" + (System.currentTimeMillis() - currentTimeMillis));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    c.a(this.Kur);
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.c.a.AnonymousClass1 */
                    final /* synthetic */ a Kus;

                    {
                        this.Kus = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(231055);
                        this.Kus.Kur.Kuf.bqe();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(231055);
                        return xVar;
                    }
                });
                Log.i("MicroMsg.FileSelectorUI", "[isInit:" + z + "] fav load data end:" + (System.currentTimeMillis() - currentTimeMillis) + ", startIndex:" + this.Kur.startIndex);
                AppMethodBeat.o(231056);
            }
        }

        /* access modifiers changed from: package-private */
        public final void gsk() {
            AppMethodBeat.i(231057);
            com.tencent.f.h.RTc.aX(new a(this));
            AppMethodBeat.o(231057);
        }

        private static List<com.tencent.mm.plugin.fav.a.g> ix(List<? extends com.tencent.mm.plugin.fav.a.g> list) {
            AppMethodBeat.i(231059);
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.plugin.fav.a.g gVar : list) {
                if (gVar.field_type == 18 || gVar.field_type == 14) {
                    try {
                        LinkedList<aml> byK = gVar.field_favProto.byK();
                        kotlin.g.b.p.g(byK, "favItemInfo.field_favProto.getDataList()");
                        LinkedList<aml> linkedList = byK;
                        int i2 = gVar.field_type == 18 ? 1 : 0;
                        while (i2 < linkedList.size()) {
                            aml aml = linkedList.get(i2);
                            if (aml.getDataType() == 8) {
                                com.tencent.mm.plugin.fav.a.g cUC = gVar.cUC();
                                cUC.field_type = 8;
                                cUC.tad = true;
                                cUC.tae = gVar;
                                cUC.dLb = String.valueOf(gVar.field_localId) + "_" + aml.gsp();
                                cUC.taf = aml.gsp();
                                cUC.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(gVar.field_favProto);
                                cUC.field_favProto.ppH = new LinkedList<>();
                                cUC.field_favProto.ppH.add(aml);
                                anb anb = cUC.field_favProto;
                                kotlin.g.b.p.g(anb, "tempFavItemInfo.field_favProto");
                                anb.bhd(aml.getTitle());
                                arrayList.add(cUC);
                                i2++;
                            } else {
                                i2++;
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FileSelectorUI", "getSearchList() [%s] Exception:%s %s", 8, e2.getClass().getSimpleName(), e2.getMessage());
                    }
                } else {
                    arrayList.add(gVar);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(231059);
            return arrayList2;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x010f  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01e6  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01e9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void iw(java.util.List<? extends com.tencent.mm.plugin.fav.a.g> r14) {
            /*
            // Method dump skipped, instructions count: 580
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.c.iw(java.util.List):void");
        }

        public final void gsl() {
            AppMethodBeat.i(231058);
            this.hasInit = false;
            this.startIndex = 0;
            this.Kut = 100;
            gsk();
            AppMethodBeat.o(231058);
        }

        public static final /* synthetic */ int a(c cVar) {
            AppMethodBeat.i(231062);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(af.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFav::class.java)");
            List<com.tencent.mm.plugin.fav.a.g> fT = ((af) ah).getFavItemInfoStorage().fT(cVar.startIndex, cVar.Kut);
            ArrayList arrayList = new ArrayList();
            kotlin.g.b.p.g(fT, "favFileList");
            arrayList.addAll(ix(fT));
            cVar.startIndex += cVar.Kut;
            if (arrayList.size() <= 0) {
                AppMethodBeat.o(231062);
                return 0;
            }
            cVar.iw(arrayList);
            int size = arrayList.size();
            AppMethodBeat.o(231062);
            return size;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002:\u0001\u001bB\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J%\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\fH\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001f\u0010\u0019\u001a\u00020\u000f2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "curFile", "Lcom/tencent/mm/vfs/VFSFile;", "filterDir", "", "rootPath", "subFiles", "", "[Lcom/tencent/mm/vfs/VFSFile;", "createTargetList", "", "deduplicateFolders", "files", "([Lcom/tencent/mm/vfs/VFSFile;)[Lcom/tencent/mm/vfs/VFSFile;", "getParent", "initASync", "loadMoreAsync", "setPath", "setRoot", "root", "sort", "([Lcom/tencent/mm/vfs/VFSFile;)V", "FileSort", "app_release"})
    public final class m extends d {
        private com.tencent.mm.vfs.o KtW;
        private com.tencent.mm.vfs.o[] KtX = new com.tencent.mm.vfs.o[0];
        final /* synthetic */ FileSelectorUI Kup;
        private com.tencent.mm.vfs.o Kva;
        boolean Kvb;

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a \u0006*\f\u0018\u00010\u0003R\u00060\u0004R\u00020\u00050\u0003R\u00060\u0004R\u00020\u00052\u001e\u0010\u0007\u001a\u001a \u0006*\f\u0018\u00010\u0003R\u00060\u0004R\u00020\u00050\u0003R\u00060\u0004R\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "f1", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "kotlin.jvm.PlatformType", "f2", "compare"})
        public static final class d<T> implements Comparator<a> {
            public static final d Kvf = new d();

            static {
                AppMethodBeat.i(231111);
                AppMethodBeat.o(231111);
            }

            d() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                AppMethodBeat.i(231110);
                a aVar3 = aVar2;
                String str = aVar.Kvc;
                if (str == null) {
                    kotlin.g.b.p.hyc();
                }
                String str2 = aVar3.Kvc;
                if (str2 == null) {
                    kotlin.g.b.p.hyc();
                }
                int compareTo = str.compareTo(str2);
                AppMethodBeat.o(231110);
                return compareTo;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a \u0006*\f\u0018\u00010\u0003R\u00060\u0004R\u00020\u00050\u0003R\u00060\u0004R\u00020\u00052\u001e\u0010\u0007\u001a\u001a \u0006*\f\u0018\u00010\u0003R\u00060\u0004R\u00020\u00050\u0003R\u00060\u0004R\u00020\u0005H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "f1", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "kotlin.jvm.PlatformType", "f2", "compare"})
        public static final class e<T> implements Comparator<a> {
            public static final e Kvg = new e();

            static {
                AppMethodBeat.i(231112);
                AppMethodBeat.o(231112);
            }

            e() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                a aVar3 = aVar;
                a aVar4 = aVar2;
                if (aVar3.time == aVar4.time) {
                    return 0;
                }
                return aVar3.time > aVar4.time ? -1 : 1;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(FileSelectorUI fileSelectorUI, e eVar) {
            super(fileSelectorUI, eVar);
            kotlin.g.b.p.h(eVar, "adapter");
            this.Kup = fileSelectorUI;
            AppMethodBeat.i(231118);
            AppMethodBeat.o(231118);
        }

        private final void ac(com.tencent.mm.vfs.o oVar) {
            this.Kva = oVar;
            this.Kvb = false;
        }

        public final void ad(com.tencent.mm.vfs.o oVar) {
            com.tencent.mm.vfs.o[] oVarArr;
            AppMethodBeat.i(231113);
            kotlin.g.b.p.h(oVar, "curFile");
            this.KtW = oVar;
            com.tencent.mm.vfs.o oVar2 = this.KtW;
            if (oVar2 == null) {
                kotlin.g.b.p.btv("curFile");
            }
            if (oVar2 != null) {
                com.tencent.mm.vfs.o oVar3 = this.KtW;
                if (oVar3 == null) {
                    kotlin.g.b.p.btv("curFile");
                }
                if (oVar3 == null) {
                    kotlin.g.b.p.hyc();
                }
                if (oVar3.canRead()) {
                    com.tencent.mm.vfs.o oVar4 = this.KtW;
                    if (oVar4 == null) {
                        kotlin.g.b.p.btv("curFile");
                    }
                    if (oVar4 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (oVar4.isDirectory()) {
                        com.tencent.mm.vfs.o oVar5 = this.KtW;
                        if (oVar5 == null) {
                            kotlin.g.b.p.btv("curFile");
                        }
                        if (oVar5 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        this.KtX = oVar5.a(new c(this));
                        if (this.KtX == null) {
                            this.KtX = new com.tencent.mm.vfs.o[0];
                        }
                        com.tencent.mm.vfs.o[] oVarArr2 = this.KtX;
                        if (oVarArr2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        if (!(oVarArr2.length == 0)) {
                            com.tencent.mm.vfs.o[] oVarArr3 = this.KtX;
                            if (oVarArr3 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            if (oVarArr3 != null) {
                                if (!(oVarArr3.length == 0)) {
                                    HashSet hashSet = new HashSet();
                                    ArrayList arrayList = new ArrayList();
                                    for (com.tencent.mm.vfs.o oVar6 : oVarArr3) {
                                        if (oVar6 == null) {
                                            kotlin.g.b.p.hyc();
                                        }
                                        if (!oVar6.isDirectory()) {
                                            arrayList.add(oVar6);
                                        } else {
                                            String absolutePath = oVar6.getAbsolutePath();
                                            kotlin.g.b.p.g(absolutePath, "file.absolutePath");
                                            if (!hashSet.contains(absolutePath)) {
                                                String absolutePath2 = oVar6.getAbsolutePath();
                                                kotlin.g.b.p.g(absolutePath2, "file.absolutePath");
                                                hashSet.add(absolutePath2);
                                                arrayList.add(oVar6);
                                            }
                                        }
                                    }
                                    Object[] array = arrayList.toArray(new com.tencent.mm.vfs.o[0]);
                                    if (array == null) {
                                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                                        AppMethodBeat.o(231113);
                                        throw tVar;
                                    }
                                    oVarArr = (com.tencent.mm.vfs.o[]) array;
                                    this.KtX = oVarArr;
                                    a(this.KtX);
                                }
                            }
                            oVarArr = oVarArr3;
                            this.KtX = oVarArr;
                            a(this.KtX);
                        }
                    }
                }
            }
            this.Kuu.clear();
            gss();
            AppMethodBeat.o(231113);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "pathname", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
        public static final class c implements com.tencent.mm.vfs.q {
            final /* synthetic */ m Kvd;

            c(m mVar) {
                this.Kvd = mVar;
            }

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(com.tencent.mm.vfs.o oVar) {
                AppMethodBeat.i(231109);
                kotlin.g.b.p.h(oVar, "pathname");
                if (oVar.isHidden()) {
                    AppMethodBeat.o(231109);
                    return false;
                }
                String name = oVar.getName();
                kotlin.g.b.p.g(name, "pathname.name");
                if (!e.bfr(name)) {
                    String name2 = oVar.getName();
                    kotlin.g.b.p.g(name2, "pathname.name");
                    if (!e.by(name2)) {
                        if (!this.Kvd.Kvb || !oVar.isDirectory()) {
                            AppMethodBeat.o(231109);
                            return true;
                        }
                        AppMethodBeat.o(231109);
                        return false;
                    }
                }
                AppMethodBeat.o(231109);
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x001d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void gss() {
            /*
            // Method dump skipped, instructions count: 147
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.m.gss():void");
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "filename", "", "accept"})
        public static final class b implements com.tencent.mm.vfs.w {
            public static final b Kve = new b();

            static {
                AppMethodBeat.i(231108);
                AppMethodBeat.o(231108);
            }

            b() {
            }

            @Override // com.tencent.mm.vfs.w
            public final boolean accept(com.tencent.mm.vfs.o oVar, String str) {
                AppMethodBeat.i(231107);
                kotlin.g.b.p.h(str, "filename");
                if (!kotlin.n.n.J(str, ".", false)) {
                    AppMethodBeat.o(231107);
                    return true;
                }
                AppMethodBeat.o(231107);
                return false;
            }
        }

        public final com.tencent.mm.vfs.o gst() {
            AppMethodBeat.i(231115);
            com.tencent.mm.vfs.o oVar = this.KtW;
            if (oVar == null) {
                kotlin.g.b.p.btv("curFile");
            }
            int hashCode = oVar.hashCode();
            com.tencent.mm.vfs.o oVar2 = this.Kva;
            if (oVar2 == null) {
                kotlin.g.b.p.btv("rootPath");
            }
            if (hashCode == oVar2.hashCode()) {
                AppMethodBeat.o(231115);
                return null;
            }
            com.tencent.mm.vfs.o oVar3 = this.KtW;
            if (oVar3 == null) {
                kotlin.g.b.p.btv("curFile");
            }
            if (oVar3 == null) {
                kotlin.g.b.p.hyc();
            }
            com.tencent.mm.vfs.o heq = oVar3.heq();
            AppMethodBeat.o(231115);
            return heq;
        }

        private final void a(com.tencent.mm.vfs.o[] oVarArr) {
            AppMethodBeat.i(231116);
            if (oVarArr != null) {
                if (!(oVarArr.length == 0)) {
                    ArrayList<a> arrayList = new ArrayList();
                    ArrayList<a> arrayList2 = new ArrayList();
                    for (com.tencent.mm.vfs.o oVar : oVarArr) {
                        a aVar = new a();
                        aVar.file = oVar;
                        if (oVar == null) {
                            kotlin.g.b.p.hyc();
                        }
                        aVar.time = oVar.lastModified();
                        if (oVar.isDirectory()) {
                            String Sh = com.tencent.mm.platformtools.f.Sh(oVar.getName());
                            kotlin.g.b.p.g(Sh, "CnToSpell.getFullSpell(file.name)");
                            if (Sh == null) {
                                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(231116);
                                throw tVar;
                            }
                            String upperCase = Sh.toUpperCase();
                            kotlin.g.b.p.g(upperCase, "(this as java.lang.String).toUpperCase()");
                            aVar.Kvc = upperCase;
                            arrayList.add(aVar);
                        } else {
                            arrayList2.add(aVar);
                        }
                    }
                    kotlin.a.j.a((List) arrayList, (Comparator) d.Kvf);
                    Collections.sort(arrayList2, e.Kvg);
                    int i2 = 0;
                    for (a aVar2 : arrayList) {
                        oVarArr[i2] = aVar2.file;
                        i2++;
                    }
                    for (a aVar3 : arrayList2) {
                        oVarArr[i2] = aVar3.file;
                        i2++;
                    }
                    AppMethodBeat.o(231116);
                    return;
                }
            }
            AppMethodBeat.o(231116);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;)V", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFile", "()Lcom/tencent/mm/vfs/VFSFile;", "setFile", "(Lcom/tencent/mm/vfs/VFSFile;)V", "spell", "", "getSpell", "()Ljava/lang/String;", "setSpell", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "app_release"})
        public final class a {
            String Kvc;
            com.tencent.mm.vfs.o file;
            long time;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a() {
            }
        }

        public final void gsl() {
            AppMethodBeat.i(231117);
            ac(new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKE()));
            ad(new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKE()));
            AppMethodBeat.o(231117);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0004\u0018\u00002\u00020\u0001:\u0003LMNB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0006\u0010\u001a\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0014\u0010\u001d\u001a\u00060\u000eR\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J2\u0010\"\u001a\u001a\u0012\b\u0012\u00060\u000eR\u00020\t0#j\f\u0012\b\u0012\u00060\u000eR\u00020\t`$2\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0014R\u00020\t0\rH\u0002J\b\u0010%\u001a\u0004\u0018\u00010&J\u0014\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020.H\u0017J\b\u0010/\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u00103\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u00104\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u000201H\u0002J\u0010\u00106\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u000e\u00107\u001a\u0002012\u0006\u00102\u001a\u00020\u0006J\u0010\u00108\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u0010:\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u0010;\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u0010<\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u0010=\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u0010>\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u000e\u0010?\u001a\u0002012\u0006\u00102\u001a\u00020\u0006J\u0010\u0010@\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\b\u0010A\u001a\u00020\u0018H\u0002J\u0006\u0010B\u001a\u00020\u0018J\u0010\u0010C\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010D\u001a\u00020\u0018J\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020+H\u0002J\u000e\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u0006J\u000e\u0010I\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010J\u001a\u00020\u0018J\u000e\u0010K\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\b\u0012\u00060\u000eR\u00020\t0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0014R\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006O"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "FILE_TYPE_COUNT", "", "TAG", "", "chattingFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "favFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FavFileSource;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "fromType", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "sdcardFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "selectedFileLst", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getSelectedFileLst", "()Ljava/util/List;", "finish", "", "getCount", "getDataSourceFrom", "getIconSrc", "name", "getItem", "position", "getItemId", "", "getItemViewType", "getListItemFromData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getParentPath", "Lcom/tencent/mm/vfs/VFSFile;", "getThumbnail", "Landroid/graphics/Bitmap;", "path", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "isAudio", "", DownloadInfo.FILENAME, "isCompressFile", "isDoc", "isFromSDCard", "isHtml", "isImg", "isInit", "isKeynote", "isNumber", "isPages", "isPdf", "isPpt", "isTxt", "isVideo", "isXls", "loadData", "onBottomLoadMore", "onInit", "onLoadMoreCompleted", "onSelectorWrapperClicked", "v", "search", "content", "setDataSourceFrom", "setParentPath", "setPath", "FileViewHolder", "FolderViewHolder", "TimeViewHolder", "app_release"})
    public final class e extends BaseAdapter {
        final m KuA;
        g KuB;
        private List<k> Kuu;
        private final int Kuw = 4;
        final List<i> Kux;
        final a Kuy;
        final c Kuz;
        private final String TAG = "MicroMsg.FileSelectorAdapter";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e() {
            AppMethodBeat.i(231093);
            List<k> synchronizedList = Collections.synchronizedList(new ArrayList());
            kotlin.g.b.p.g(synchronizedList, "Collections.synchronized…st(ArrayList<ListItem>())");
            this.Kuu = synchronizedList;
            List<i> synchronizedList2 = Collections.synchronizedList(new ArrayList());
            kotlin.g.b.p.g(synchronizedList2, "Collections.synchronized…rrayList<ListFileItem>())");
            this.Kux = synchronizedList2;
            this.Kuy = new a(FileSelectorUI.this, this);
            this.Kuz = new c(FileSelectorUI.this, this);
            this.KuA = new m(FileSelectorUI.this, this);
            this.KuB = g.FROM_CHATTING;
            AppMethodBeat.o(231093);
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(231077);
            k aiR = aiR(i2);
            AppMethodBeat.o(231077);
            return aiR;
        }

        public final void a(g gVar) {
            AppMethodBeat.i(231066);
            kotlin.g.b.p.h(gVar, "fromType");
            if (!b(gVar)) {
                c(gVar);
            }
            this.KuB = gVar;
            bqe();
            AppMethodBeat.o(231066);
        }

        public final void DO(String str) {
            ArrayList<k> iy;
            AppMethodBeat.i(231067);
            kotlin.g.b.p.h(str, "content");
            switch (f.$EnumSwitchMapping$0[this.KuB.ordinal()]) {
                case 1:
                    iy = iy(this.Kuy.bfx(str));
                    break;
                case 2:
                    iy = iy(this.Kuz.bfx(str));
                    break;
                case 3:
                    iy = iy(this.KuA.bfx(str));
                    break;
                default:
                    kotlin.m mVar = new kotlin.m();
                    AppMethodBeat.o(231067);
                    throw mVar;
            }
            this.Kuu = iy;
            notifyDataSetChanged();
            AppMethodBeat.o(231067);
        }

        private final boolean b(g gVar) {
            AppMethodBeat.i(231068);
            switch (f.haE[gVar.ordinal()]) {
                case 1:
                    boolean z = this.Kuy.hasInit;
                    AppMethodBeat.o(231068);
                    return z;
                case 2:
                    boolean z2 = this.Kuz.hasInit;
                    AppMethodBeat.o(231068);
                    return z2;
                case 3:
                    boolean z3 = this.KuA.hasInit;
                    AppMethodBeat.o(231068);
                    return z3;
                default:
                    kotlin.m mVar = new kotlin.m();
                    AppMethodBeat.o(231068);
                    throw mVar;
            }
        }

        /* access modifiers changed from: package-private */
        public final void bqe() {
            ArrayList<k> iy;
            View emptyView;
            AppMethodBeat.i(231069);
            switch (f.uqL[this.KuB.ordinal()]) {
                case 1:
                    iy = iy(this.Kuy.Kuu);
                    break;
                case 2:
                    iy = iy(this.Kuz.Kuu);
                    break;
                case 3:
                    iy = iy(this.KuA.Kuu);
                    break;
                default:
                    kotlin.m mVar = new kotlin.m();
                    AppMethodBeat.o(231069);
                    throw mVar;
            }
            this.Kuu = iy;
            notifyDataSetChanged();
            if (this.Kuu.size() > 0 || (emptyView = FileSelectorUI.c(FileSelectorUI.this).getEmptyView()) == null) {
                AppMethodBeat.o(231069);
                return;
            }
            emptyView.setVisibility(0);
            AppMethodBeat.o(231069);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private final void c(g gVar) {
            AppMethodBeat.i(231070);
            switch (f.vke[gVar.ordinal()]) {
                case 1:
                    this.Kuy.gsl();
                    AppMethodBeat.o(231070);
                    return;
                case 2:
                    this.Kuz.gsl();
                    AppMethodBeat.o(231070);
                    return;
                case 3:
                    this.KuA.gsl();
                    break;
            }
            AppMethodBeat.o(231070);
        }

        public final void gsm() {
            AppMethodBeat.i(231071);
            if (this.KuB != g.FROM_SDCARD) {
                AppMethodBeat.o(231071);
            } else if (this.KuA.gst() == null) {
                AppMethodBeat.o(231071);
            } else {
                m mVar = this.KuA;
                com.tencent.mm.vfs.o gst = this.KuA.gst();
                if (gst == null) {
                    kotlin.g.b.p.hyc();
                }
                mVar.ad(gst);
                FileSelectorUI.d(FileSelectorUI.this).bqe();
                AppMethodBeat.o(231071);
            }
        }

        public final com.tencent.mm.vfs.o gsn() {
            AppMethodBeat.i(231072);
            if (!gso()) {
                AppMethodBeat.o(231072);
                return null;
            }
            com.tencent.mm.vfs.o gst = this.KuA.gst();
            AppMethodBeat.o(231072);
            return gst;
        }

        private final boolean gso() {
            return g.FROM_SDCARD == this.KuB;
        }

        private final ArrayList<k> iy(List<i> list) {
            String str;
            AppMethodBeat.i(231073);
            ArrayList<k> arrayList = new ArrayList<>();
            String str2 = "";
            for (T t : list) {
                if (t == null || f.TYPE_INVALID == t.KuY) {
                    String str3 = this.TAG;
                    if (t == null) {
                        str = "getListItemFromData, fileItem=null";
                    } else {
                        str = "getListItemFromData, type:FileType.TYPE_INVALID";
                    }
                    Log.e(str3, str);
                } else {
                    if (f.TYPE_FOLDER != t.KuY && (!kotlin.g.b.p.j(str2, t.title))) {
                        l lVar = new l();
                        lVar.title = t.title;
                        str2 = lVar.title;
                        if (str2 == null) {
                            str2 = "";
                        }
                        lVar.a(f.TYPE_TIME);
                        arrayList.add(lVar);
                    }
                    arrayList.add(t);
                }
            }
            AppMethodBeat.o(231073);
            return arrayList;
        }

        public final int getViewTypeCount() {
            return this.Kuw;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(231074);
            int ordinal = aiR(i2).KuY.ordinal();
            AppMethodBeat.o(231074);
            return ordinal;
        }

        public final int getCount() {
            AppMethodBeat.i(231075);
            List<k> list = this.Kuu;
            if (list == null) {
                kotlin.g.b.p.hyc();
            }
            int size = list.size();
            AppMethodBeat.o(231075);
            return size;
        }

        public final k aiR(int i2) {
            AppMethodBeat.i(231076);
            k kVar = this.Kuu.get(i2);
            AppMethodBeat.o(231076);
            return kVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        @SuppressLint({"ResourceType"})
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            Bitmap bitmap;
            a aVar;
            View view2;
            c cVar;
            AppMethodBeat.i(231078);
            kotlin.g.b.p.h(viewGroup, "parent");
            k aiR = aiR(i2);
            switch (f.vlj[aiR.KuY.ordinal()]) {
                case 1:
                    if (view == null) {
                        view = View.inflate(viewGroup.getContext(), R.layout.a8w, null);
                        c cVar2 = new c();
                        View findViewById = view.findViewById(R.id.e40);
                        if (findViewById == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                            AppMethodBeat.o(231078);
                            throw tVar;
                        }
                        cVar2.jVO = (TextView) findViewById;
                        kotlin.g.b.p.g(view, "convertView");
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        Object tag = view.getTag();
                        if (tag == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.TimeViewHolder");
                            AppMethodBeat.o(231078);
                            throw tVar2;
                        }
                        cVar = (c) tag;
                    }
                    TextView textView = cVar.jVO;
                    if (textView == null) {
                        kotlin.g.b.p.hyc();
                    }
                    textView.setText(aiR.title);
                    AppMethodBeat.o(231078);
                    break;
                case 2:
                    if (view == null) {
                        view = View.inflate(viewGroup.getContext(), R.layout.a8u, null);
                        a aVar2 = new a();
                        View findViewById2 = view.findViewById(R.id.e3p);
                        if (findViewById2 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
                            AppMethodBeat.o(231078);
                            throw tVar3;
                        }
                        aVar2.KuC = (FrameLayout) findViewById2;
                        FrameLayout frameLayout = aVar2.KuC;
                        if (frameLayout == null) {
                            kotlin.g.b.p.hyc();
                        }
                        View findViewById3 = frameLayout.findViewById(R.id.e3o);
                        if (findViewById3 == null) {
                            kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
                            AppMethodBeat.o(231078);
                            throw tVar4;
                        }
                        aVar2.KuD = (CheckBox) findViewById3;
                        View findViewById4 = view.findViewById(R.id.e2f);
                        if (findViewById4 == null) {
                            kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
                            AppMethodBeat.o(231078);
                            throw tVar5;
                        }
                        aVar2.nnL = (ImageView) findViewById4;
                        View findViewById5 = view.findViewById(R.id.e40);
                        if (findViewById5 == null) {
                            kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                            AppMethodBeat.o(231078);
                            throw tVar6;
                        }
                        aVar2.jVO = (TextView) findViewById5;
                        View findViewById6 = view.findViewById(R.id.e3t);
                        if (findViewById6 == null) {
                            kotlin.t tVar7 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                            AppMethodBeat.o(231078);
                            throw tVar7;
                        }
                        aVar2.Bvi = (TextView) findViewById6;
                        View findViewById7 = view.findViewById(R.id.e3y);
                        if (findViewById7 == null) {
                            kotlin.t tVar8 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                            AppMethodBeat.o(231078);
                            throw tVar8;
                        }
                        aVar2.timeTV = (TextView) findViewById7;
                        View findViewById8 = view.findViewById(R.id.e2d);
                        if (findViewById8 == null) {
                            kotlin.t tVar9 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                            AppMethodBeat.o(231078);
                            throw tVar9;
                        }
                        aVar2.KuE = (TextView) findViewById8;
                        aVar2.KuF = view.findViewById(R.id.e2u);
                        if (getCount() - 1 == i2 && (view2 = aVar2.KuF) != null) {
                            view2.setVisibility(4);
                        }
                        FrameLayout frameLayout2 = aVar2.KuC;
                        if (frameLayout2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        frameLayout2.setOnClickListener(new d(this));
                        kotlin.g.b.p.g(view, "convertView");
                        view.setTag(aVar2);
                        aVar = aVar2;
                    } else {
                        Object tag2 = view.getTag();
                        if (tag2 == null) {
                            kotlin.t tVar10 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FileViewHolder");
                            AppMethodBeat.o(231078);
                            throw tVar10;
                        }
                        aVar = (a) tag2;
                    }
                    TextView textView2 = aVar.jVO;
                    if (textView2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (aiR != null) {
                        textView2.setText(((i) aiR).gsq());
                        if (3 == FileSelectorUI.this.scene) {
                            FrameLayout frameLayout3 = aVar.KuC;
                            if (frameLayout3 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            frameLayout3.setVisibility(4);
                        } else {
                            FrameLayout frameLayout4 = aVar.KuC;
                            if (frameLayout4 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            frameLayout4.setVisibility(0);
                        }
                        TextView textView3 = aVar.Bvi;
                        if (textView3 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView3.setVisibility(0);
                        TextView textView4 = aVar.timeTV;
                        if (textView4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView4.setVisibility(0);
                        TextView textView5 = aVar.jVO;
                        if (textView5 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView5.setText(((i) aiR).gsq());
                        TextView textView6 = aVar.Bvi;
                        if (textView6 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView6.setText(Util.getSizeKB((long) ((i) aiR).zGp));
                        if (((i) aiR).KuU == 2) {
                            TextView textView7 = aVar.Bvi;
                            if (textView7 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView7.setText(">" + ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true) + "MB");
                        }
                        TextView textView8 = aVar.timeTV;
                        if (textView8 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView8.setText(com.tencent.mm.pluginsdk.i.f.c(FileSelectorUI.this.getContext(), ((i) aiR).createTime, true));
                        ImageView imageView = aVar.nnL;
                        if (imageView == null) {
                            kotlin.g.b.p.hyc();
                        }
                        imageView.setImageResource(bfq(((i) aiR).gsq().toString()));
                        TextView textView9 = aVar.KuE;
                        if (textView9 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView9.setText(((i) aiR).KuS);
                        CheckBox checkBox = aVar.KuD;
                        if (checkBox == null) {
                            kotlin.g.b.p.hyc();
                        }
                        checkBox.setChecked(this.Kux.contains(aiR));
                        FrameLayout frameLayout5 = aVar.KuC;
                        if (frameLayout5 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        frameLayout5.setTag(Integer.valueOf(i2));
                        AppMethodBeat.o(231078);
                        break;
                    } else {
                        kotlin.t tVar11 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
                        AppMethodBeat.o(231078);
                        throw tVar11;
                    }
                case 3:
                    if (view == null) {
                        view = View.inflate(viewGroup.getContext(), R.layout.alv, null);
                        b bVar2 = new b();
                        bVar2.KuC = (FrameLayout) view.findViewById(R.id.e3p);
                        FrameLayout frameLayout6 = bVar2.KuC;
                        if (frameLayout6 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        View findViewById9 = frameLayout6.findViewById(R.id.e3o);
                        if (findViewById9 == null) {
                            kotlin.t tVar12 = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
                            AppMethodBeat.o(231078);
                            throw tVar12;
                        }
                        bVar2.KuD = (CheckBox) findViewById9;
                        bVar2.nnL = (ImageView) view.findViewById(R.id.e2f);
                        bVar2.jVO = (TextView) view.findViewById(R.id.e40);
                        bVar2.Bvi = (TextView) view.findViewById(R.id.e3t);
                        bVar2.timeTV = (TextView) view.findViewById(R.id.e3y);
                        FrameLayout frameLayout7 = bVar2.KuC;
                        if (frameLayout7 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        frameLayout7.setOnClickListener(new View$OnClickListenerC2033e(this));
                        kotlin.g.b.p.g(view, "convertView");
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        Object tag3 = view.getTag();
                        if (tag3 == null) {
                            kotlin.t tVar13 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FolderViewHolder");
                            AppMethodBeat.o(231078);
                            throw tVar13;
                        }
                        bVar = (b) tag3;
                    }
                    if (aiR != null) {
                        j jVar = (j) aiR;
                        TextView textView10 = bVar.jVO;
                        if (textView10 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        textView10.setText(jVar != null ? jVar.gsq() : null);
                        if (!(jVar != null ? Boolean.valueOf(jVar.KuX) : null).booleanValue()) {
                            ImageView imageView2 = bVar.nnL;
                            if (imageView2 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            imageView2.setImageResource(R.raw.app_attach_file_icon_folders);
                            FrameLayout frameLayout8 = bVar.KuC;
                            if (frameLayout8 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            frameLayout8.setVisibility(4);
                            TextView textView11 = bVar.Bvi;
                            if (textView11 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView11.setVisibility(0);
                            TextView textView12 = bVar.timeTV;
                            if (textView12 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView12.setVisibility(8);
                            TextView textView13 = bVar.Bvi;
                            if (textView13 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView13.setText(FileSelectorUI.this.getString(R.string.cdt, new Object[]{Integer.valueOf(jVar.KuW)}));
                        } else {
                            if (3 == FileSelectorUI.this.scene) {
                                FrameLayout frameLayout9 = bVar.KuC;
                                if (frameLayout9 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                frameLayout9.setVisibility(4);
                            } else {
                                FrameLayout frameLayout10 = bVar.KuC;
                                if (frameLayout10 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                frameLayout10.setVisibility(0);
                            }
                            TextView textView14 = bVar.Bvi;
                            if (textView14 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView14.setVisibility(0);
                            TextView textView15 = bVar.timeTV;
                            if (textView15 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView15.setVisibility(0);
                            TextView textView16 = bVar.Bvi;
                            if (textView16 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView16.setText(Util.getSizeKB((long) jVar.zGp));
                            TextView textView17 = bVar.timeTV;
                            if (textView17 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            textView17.setText(com.tencent.mm.pluginsdk.i.f.c(FileSelectorUI.this.getContext(), jVar.createTime, true));
                            CharSequence gsq = jVar.gsq();
                            if (bfr(gsq.toString())) {
                                e d2 = FileSelectorUI.d(FileSelectorUI.this);
                                if (d2 != null) {
                                    String str = jVar.filePath;
                                    if (Util.isNullOrNil(str)) {
                                        Log.e(d2.TAG, "getThumbnail fail, path not exist");
                                    } else {
                                        Cursor query = FileSelectorUI.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
                                        if (query != null) {
                                            if (query.moveToFirst()) {
                                                int i3 = query.getInt(query.getColumnIndex("_id"));
                                                query.close();
                                                bitmap = MediaStore.Images.Thumbnails.getThumbnail(FileSelectorUI.this.getContentResolver(), (long) i3, 3, null);
                                            } else {
                                                query.close();
                                            }
                                        }
                                    }
                                    bitmap = null;
                                } else {
                                    bitmap = null;
                                }
                                if (bitmap != null) {
                                    ImageView imageView3 = bVar.nnL;
                                    if (imageView3 == null) {
                                        kotlin.g.b.p.hyc();
                                    }
                                    imageView3.setImageBitmap(bitmap);
                                } else {
                                    ImageView imageView4 = bVar.nnL;
                                    if (imageView4 == null) {
                                        kotlin.g.b.p.hyc();
                                    }
                                    imageView4.setImageResource(bfq(gsq.toString()));
                                }
                            } else {
                                ImageView imageView5 = bVar.nnL;
                                if (imageView5 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                imageView5.setImageResource(bfq(gsq.toString()));
                            }
                        }
                        CheckBox checkBox2 = bVar.KuD;
                        if (checkBox2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        checkBox2.setChecked(this.Kux.contains(jVar));
                        FrameLayout frameLayout11 = bVar.KuC;
                        if (frameLayout11 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        frameLayout11.setTag(Integer.valueOf(i2));
                        AppMethodBeat.o(231078);
                        break;
                    } else {
                        try {
                            kotlin.t tVar14 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFolderItem");
                            AppMethodBeat.o(231078);
                            throw tVar14;
                        } catch (Exception e2) {
                            Log.e(this.TAG, e2.getMessage(), "item is ListFileItem:" + (aiR instanceof i));
                        }
                    }
                default:
                    Log.f(this.TAG, "impossible path, Fuck felixzhou!");
                    if (view == null) {
                        kotlin.g.b.p.hyc();
                    }
                    AppMethodBeat.o(231078);
                    break;
            }
            return view;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class d implements View.OnClickListener {
            final /* synthetic */ e KuG;

            d(e eVar) {
                this.KuG = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(231064);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = this.KuG;
                kotlin.g.b.p.g(view, "v");
                e.a(eVar, view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231064);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI$e$e  reason: collision with other inner class name */
        static final class View$OnClickListenerC2033e implements View.OnClickListener {
            final /* synthetic */ e KuG;

            View$OnClickListenerC2033e(e eVar) {
                this.KuG = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(231065);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = this.KuG;
                kotlin.g.b.p.g(view, "v");
                e.a(eVar, view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231065);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FileViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "fromTV", "Landroid/widget/TextView;", "getFromTV", "()Landroid/widget/TextView;", "setFromTV", "(Landroid/widget/TextView;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "lineV", "Landroid/view/View;", "getLineV", "()Landroid/view/View;", "setLineV", "(Landroid/view/View;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "getSizeTV", "setSizeTV", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"})
        final class a {
            TextView Bvi;
            FrameLayout KuC;
            CheckBox KuD;
            TextView KuE;
            View KuF;
            TextView jVO;
            ImageView nnL;
            TextView timeTV;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a() {
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006!"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FolderViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "Landroid/widget/TextView;", "getSizeTV", "()Landroid/widget/TextView;", "setSizeTV", "(Landroid/widget/TextView;)V", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"})
        final class b {
            TextView Bvi;
            FrameLayout KuC;
            CheckBox KuD;
            TextView jVO;
            ImageView nnL;
            TextView timeTV;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b() {
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$TimeViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "titleTV", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "setTitleTV", "(Landroid/widget/TextView;)V", "app_release"})
        final class c {
            TextView jVO;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            public c() {
            }
        }

        private static int bfq(String str) {
            AppMethodBeat.i(231079);
            if (str == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231079);
                throw tVar;
            }
            String lowerCase = str.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (bft(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_word;
            } else if (bfr(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.drawable.bxc;
            } else if (bfy(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_rar;
            } else if (bfz(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_txt;
            } else if (bfu(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_pdf;
            } else if (bfv(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_ppt;
            } else if (bfw(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_excel;
            } else if (bx(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_music;
            } else if (by(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_video;
            } else if (df(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_webpage;
            } else if (bfA(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_keynote;
            } else if (bfB(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_number;
            } else if (bfC(lowerCase)) {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_page;
            } else {
                AppMethodBeat.o(231079);
                return R.raw.app_attach_file_icon_unknow;
            }
        }

        public static boolean bfr(String str) {
            AppMethodBeat.i(231080);
            kotlin.g.b.p.h(str, DownloadInfo.FILENAME);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231080);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Build.VERSION.SDK_INT >= 28 && kotlin.n.n.nm(lowerCase, ".heic")) {
                AppMethodBeat.o(231080);
                return true;
            } else if (kotlin.n.n.nm(lowerCase, ".bmp") || kotlin.n.n.nm(lowerCase, ".png") || kotlin.n.n.nm(lowerCase, ".jpg") || kotlin.n.n.nm(lowerCase, ".jpeg") || kotlin.n.n.nm(lowerCase, ".gif")) {
                AppMethodBeat.o(231080);
                return true;
            } else {
                AppMethodBeat.o(231080);
                return false;
            }
        }

        private static boolean bx(String str) {
            AppMethodBeat.i(231081);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231081);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".mp3") || kotlin.n.n.nm(lowerCase, ".wma")) {
                AppMethodBeat.o(231081);
                return true;
            }
            AppMethodBeat.o(231081);
            return false;
        }

        public static boolean by(String str) {
            AppMethodBeat.i(231082);
            kotlin.g.b.p.h(str, DownloadInfo.FILENAME);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231082);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".mp4") || kotlin.n.n.nm(lowerCase, ".rm")) {
                AppMethodBeat.o(231082);
                return true;
            }
            AppMethodBeat.o(231082);
            return false;
        }

        private static boolean bfy(String str) {
            AppMethodBeat.i(231083);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231083);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".rar") || kotlin.n.n.nm(lowerCase, ".zip") || kotlin.n.n.nm(lowerCase, ".7z") || kotlin.n.n.nm(lowerCase, "tar") || kotlin.n.n.nm(lowerCase, ".iso")) {
                AppMethodBeat.o(231083);
                return true;
            }
            AppMethodBeat.o(231083);
            return false;
        }

        private static boolean bft(String str) {
            AppMethodBeat.i(231084);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231084);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".doc") || kotlin.n.n.nm(lowerCase, ".docx") || kotlin.n.n.nm(lowerCase, "wps")) {
                AppMethodBeat.o(231084);
                return true;
            }
            AppMethodBeat.o(231084);
            return false;
        }

        private static boolean bfu(String str) {
            AppMethodBeat.i(231085);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231085);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean nm = kotlin.n.n.nm(lowerCase, ".pdf");
            AppMethodBeat.o(231085);
            return nm;
        }

        private static boolean bfv(String str) {
            AppMethodBeat.i(231086);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231086);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".ppt") || kotlin.n.n.nm(lowerCase, ".pptx")) {
                AppMethodBeat.o(231086);
                return true;
            }
            AppMethodBeat.o(231086);
            return false;
        }

        private static boolean bfw(String str) {
            AppMethodBeat.i(231087);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231087);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".xls") || kotlin.n.n.nm(lowerCase, ".xlsx")) {
                AppMethodBeat.o(231087);
                return true;
            }
            AppMethodBeat.o(231087);
            return false;
        }

        private static boolean bfz(String str) {
            AppMethodBeat.i(231088);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231088);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.n.n.nm(lowerCase, ".txt") || kotlin.n.n.nm(lowerCase, ".rtf")) {
                AppMethodBeat.o(231088);
                return true;
            }
            AppMethodBeat.o(231088);
            return false;
        }

        private static boolean bfA(String str) {
            AppMethodBeat.i(231089);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231089);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean nm = kotlin.n.n.nm(lowerCase, ".key");
            AppMethodBeat.o(231089);
            return nm;
        }

        private static boolean df(String str) {
            AppMethodBeat.i(231090);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231090);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean nm = kotlin.n.n.nm(lowerCase, ".html");
            AppMethodBeat.o(231090);
            return nm;
        }

        private static boolean bfB(String str) {
            AppMethodBeat.i(231091);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231091);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean nm = kotlin.n.n.nm(lowerCase, ".number");
            AppMethodBeat.o(231091);
            return nm;
        }

        private static boolean bfC(String str) {
            AppMethodBeat.i(231092);
            String nullAsNil = Util.nullAsNil(str);
            kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(fileName)");
            if (nullAsNil == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(231092);
                throw tVar;
            }
            String lowerCase = nullAsNil.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean nm = kotlin.n.n.nm(lowerCase, ".pages");
            AppMethodBeat.o(231092);
            return nm;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.List<com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI$i> */
        /* JADX WARN: Multi-variable type inference failed */
        public static final /* synthetic */ void a(e eVar, View view) {
            AppMethodBeat.i(231094);
            Object tag = view.getTag();
            if (tag == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(231094);
                throw tVar;
            }
            k aiR = eVar.aiR(((Integer) tag).intValue());
            View findViewById = view.findViewById(R.id.e3o);
            if (findViewById == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
                AppMethodBeat.o(231094);
                throw tVar2;
            }
            CheckBox checkBox = (CheckBox) findViewById;
            if (kotlin.a.j.a((Iterable) eVar.Kux, (Object) aiR)) {
                List<i> list = eVar.Kux;
                if (list == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    AppMethodBeat.o(231094);
                    throw tVar3;
                }
                kotlin.g.b.af.eV(list).remove(aiR);
                checkBox.setChecked(false);
            } else if (eVar.Kux.size() >= 9) {
                com.tencent.mm.ui.base.u.makeText(FileSelectorUI.this.getContext(), FileSelectorUI.this.getString(R.string.ceg, new Object[]{9}), 0).show();
                checkBox.setChecked(false);
                AppMethodBeat.o(231094);
                return;
            } else {
                int aqr = com.tencent.mm.n.c.aqr();
                if (aiR == null) {
                    kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
                    AppMethodBeat.o(231094);
                    throw tVar4;
                } else if (((i) aiR).zGp >= aqr) {
                    com.tencent.mm.ui.base.u.makeText(FileSelectorUI.this.getContext(), FileSelectorUI.this.getString(R.string.cef, new Object[]{Util.getSizeKB((long) aqr)}), 0).show();
                    checkBox.setChecked(false);
                    AppMethodBeat.o(231094);
                    return;
                } else if (!by(((i) aiR).gsq().toString()) || ((i) aiR).zGp <= com.tencent.mm.n.c.aqq()) {
                    checkBox.setChecked(true);
                    eVar.Kux.add(aiR);
                } else {
                    com.tencent.mm.ui.base.u.makeText(FileSelectorUI.this.getContext(), FileSelectorUI.this.getString(R.string.hxq, new Object[]{Util.getSizeKB((long) com.tencent.mm.n.c.aqq())}), 0).show();
                    checkBox.setChecked(false);
                    AppMethodBeat.o(231094);
                    return;
                }
            }
            FileSelectorUI.e(FileSelectorUI.this);
            FileSelectorUI.this.hideVKB();
            com.tencent.mm.ui.tools.r rVar = FileSelectorUI.this.Kug;
            if (rVar != null) {
                rVar.CJ(false);
                AppMethodBeat.o(231094);
                return;
            }
            AppMethodBeat.o(231094);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$Companion;", "", "()V", "DROPDOWN_ITEM_TYPE_COPY", "", "DROPDOWN_ITEM_TYPE_FAV", "DROPDOWN_ITEM_TYPE_FOLDER", "INTENT_SCENE", "", "INTENT_SELECTED_FILE_LIST", "INTENT_TO_USER", "INTENT_WITH_TEXT_CONTENT", "PREVIEW_REQUEST_CODE", "SCENE_FROM_C2C", "SCENE_FROM_CAST_SCREEN", "SCREEN_DOWNLOAD_CODE", "TAG", "checkOrientation", "context", "Landroid/content/Context;", "app_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static int gE(Context context) {
            AppMethodBeat.i(231054);
            kotlin.g.b.p.h(context, "context");
            Object systemService = context.getSystemService("window");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
                AppMethodBeat.o(231054);
                throw tVar;
            }
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            kotlin.g.b.p.g(defaultDisplay, "(context.getSystemServic…owManager).defaultDisplay");
            switch (defaultDisplay.getRotation()) {
                case 0:
                    AppMethodBeat.o(231054);
                    return 0;
                case 1:
                    AppMethodBeat.o(231054);
                    return 90;
                case 2:
                    AppMethodBeat.o(231054);
                    return TXLiveConstants.RENDER_ROTATION_180;
                case 3:
                    AppMethodBeat.o(231054);
                    return 270;
                default:
                    AppMethodBeat.o(231054);
                    return 0;
            }
        }
    }

    public static final /* synthetic */ void h(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231157);
        ArrayList<i> arrayList = new ArrayList();
        ArrayList<i> arrayList2 = new ArrayList();
        e eVar = fileSelectorUI.Kuf;
        if (eVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        for (i iVar : eVar.Kux) {
            if (iVar.gsr() == g.FROM_FAV) {
                arrayList2.add(iVar);
            } else {
                arrayList.add(iVar);
            }
        }
        if (arrayList2.size() > 0) {
            for (i iVar2 : arrayList2) {
                if (iVar2 == null) {
                    try {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFavFileItem");
                        AppMethodBeat.o(231157);
                        throw tVar;
                    } catch (ClassCastException e2) {
                        Log.e("MicroMsg.FileSelectorUI", e2.getMessage());
                    }
                } else {
                    h hVar = (h) iVar2;
                    String str = hVar.filePath;
                    if (Util.isNullOrNil(((h) iVar2).KuR) || iVar2.KuU != 0) {
                        if (iVar2.KuU == 2) {
                            int favSizeLimitInMB = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSizeLimitInMB(true, 8);
                            com.tencent.mm.ui.base.h.cA(fileSelectorUI.getContext(), fileSelectorUI.getContext().getString(R.string.c9j, new Object[]{Integer.valueOf(favSizeLimitInMB)}));
                        } else {
                            com.tencent.mm.ui.base.h.cA(fileSelectorUI.getContext(), fileSelectorUI.getContext().getString(R.string.c9k));
                        }
                    } else if (str == null || !iVar2.KuV) {
                        Log.e("MicroMsg.FileSelectorUI", "path:" + str + ", download:" + iVar2.KuV);
                        com.tencent.mm.ui.base.h.cA(fileSelectorUI.getContext(), fileSelectorUI.getString(R.string.f3146c));
                    } else {
                        com.tencent.mm.plugin.fav.ui.l.g(fileSelectorUI.dJw, str, hVar.KuQ, hVar.desc, hVar.gsp());
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : arrayList) {
                String str2 = iVar3.filePath;
                if (str2 == null) {
                    Log.e("MicroMsg.FileSelectorUI", "get path fail, msgInfo:" + iVar3.gsq());
                } else {
                    arrayList3.add(str2);
                }
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", arrayList3);
            intent.putExtra("GalleryUI_ToUser", fileSelectorUI.dJw);
            fileSelectorUI.setResult(-1, intent);
        }
        fileSelectorUI.finish();
        AppMethodBeat.o(231157);
    }

    public static final /* synthetic */ void b(FileSelectorUI fileSelectorUI, DropdownListView.c cVar) {
        AppMethodBeat.i(231158);
        Log.i("MicroMsg.FileSelectorUI", "reset folder[%s]", cVar.name);
        fileSelectorUI.Kui = cVar.name;
        fileSelectorUI.updateActionBarOperationAreaTxt(cVar.name);
        AppMethodBeat.o(231158);
    }

    public static final /* synthetic */ boolean m(FileSelectorUI fileSelectorUI) {
        AppMethodBeat.i(231160);
        ListView listView = fileSelectorUI.krb;
        if (listView == null) {
            kotlin.g.b.p.btv("listView");
        }
        ListView listView2 = fileSelectorUI.krb;
        if (listView2 == null) {
            kotlin.g.b.p.btv("listView");
        }
        if (listView.getChildAt(listView2.getChildCount() - 1) == null) {
            AppMethodBeat.o(231160);
            return false;
        }
        ListView listView3 = fileSelectorUI.krb;
        if (listView3 == null) {
            kotlin.g.b.p.btv("listView");
        }
        int lastVisiblePosition = listView3.getLastVisiblePosition();
        ListView listView4 = fileSelectorUI.krb;
        if (listView4 == null) {
            kotlin.g.b.p.btv("listView");
        }
        ListAdapter adapter = listView4.getAdapter();
        kotlin.g.b.p.g(adapter, "listView.adapter");
        if (lastVisiblePosition == adapter.getCount() - 1) {
            AppMethodBeat.o(231160);
            return true;
        }
        AppMethodBeat.o(231160);
        return false;
    }

    public static final /* synthetic */ void a(FileSelectorUI fileSelectorUI, String str, String str2) {
        AppMethodBeat.i(231164);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FileSelectorUI", "open file but file not exist");
            AppMethodBeat.o(231164);
            return;
        }
        String akC = com.tencent.mm.vfs.s.akC(str);
        if (3 != fileSelectorUI.scene) {
            a.b(fileSelectorUI, str, akC, 1);
            AppMethodBeat.o(231164);
        } else if (kotlin.n.n.I(akC, "ppt", true) || kotlin.n.n.I(akC, "pdf", true) || kotlin.n.n.I(akC, "doc", true) || kotlin.n.n.I(akC, "docx", true) || kotlin.n.n.I(akC, "pptx", true)) {
            if (str == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(akC, "ext");
            fileSelectorUI.bm(str2, str, akC);
            AppMethodBeat.o(231164);
        } else {
            com.tencent.mm.ui.base.u.cH(fileSelectorUI, fileSelectorUI.getResources().getString(R.string.gep));
            AppMethodBeat.o(231164);
        }
    }

    public static final /* synthetic */ void a(FileSelectorUI fileSelectorUI, long j2) {
        AppMethodBeat.i(231165);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        if (!aAh.isSDCardAvailable()) {
            com.tencent.mm.ui.base.u.g(fileSelectorUI.getContext(), null);
            AppMethodBeat.o(231165);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("scene", fileSelectorUI.scene);
        intent.setClassName(fileSelectorUI, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        intent.putExtra("app_msg_id", j2);
        fileSelectorUI.startActivityForResult(intent, 4);
        AppMethodBeat.o(231165);
    }

    public static final /* synthetic */ void a(FileSelectorUI fileSelectorUI, long j2, String str) {
        AppMethodBeat.i(231166);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", j2);
        intent.putExtra("key_detail_data_id", str);
        intent.putExtra("show_share", true);
        com.tencent.mm.plugin.fav.a.b.b(fileSelectorUI.getContext(), ".ui.detail.FavoriteFileDetailUI", intent);
        AppMethodBeat.o(231166);
    }
}
