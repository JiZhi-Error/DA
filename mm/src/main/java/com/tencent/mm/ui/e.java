package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class e {
    public static final String OyP = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m));

    public static final class b {
        public static final String OyQ = p.Ozw;
        public static final String OyR = p.Ozx;
    }

    public static final class d {
        public static String OyT = "AntispamTicket";
    }

    public interface h {
        public static final String Ozc = "FREE_WIFI_IS_DEFAULT_FOCUS".toLowerCase();
    }

    public static final class i {
        public static String Ozd = "key_envelope_source";
        public static String Oze = "key_source_resp";
        public static String Ozf = "key_has_source";
        public static String Ozg = "key_exchange_title";
        public static String Ozh = "key_exchange_url";
        public static String Ozi = "key_has_reddot";
    }

    public static final class k {
        public static int Ozj = 0;
        public static int Ozk = 1;
        public static int Ozl = 2;
    }

    public static final class l {
        public static final String gLX = null;
    }

    public static final class m {
        public static String Ozm = "trust_friend_show_tips";
    }

    public interface n {
        public static final String Ozn = MMApplicationContext.getPackageName();
        public static final String lnh = (MMApplicationContext.getPackageName() + ":tools");
    }

    static {
        AppMethodBeat.i(205107);
        AppMethodBeat.o(205107);
    }

    public static final class c {

        public static final class a {
            public static final String OyS = (HttpWrapperBase.PROTOCAL_HTTPS + MMApplicationContext.getContext().getString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=weishihb20/index");

            static {
                AppMethodBeat.i(205100);
                AppMethodBeat.o(205100);
            }
        }
    }

    public static final class o {
        public static final String Ozo = (HttpWrapperBase.PROTOCAL_HTTPS + MMApplicationContext.getContext().getString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");

        static {
            AppMethodBeat.i(205105);
            AppMethodBeat.o(205105);
        }
    }

    public static final class p {
        public static String OzA = "k_tmpl_item_show_type";
        public static String OzB = "k_tmpl_open_type";
        public static String OzC = "k_tmpl_session";
        public static String OzD = "k_tmpl_force_url";
        public static String OzE = "k_tmpl_content_id";
        public static String OzF = "k_serach_log_id";
        public static String OzG = "k_serach_log_args";
        public static String OzH = "k_scan_from_biz_username";
        public static String OzI = "ad_ux_info_for_jsapi_pay";
        public static String OzJ = "no_support_dark_mode";
        public static String OzK = "key_allow_jump_inner_jump_without_perm";
        public static final String Ozp = (HttpWrapperBase.PROTOCAL_HTTPS + MMApplicationContext.getContext().getString(R.string.e2f) + "/update/");
        public static String Ozq = "k_tmpl_params";
        public static String Ozr = "k_tmpl_next_webview";
        public static String Ozs = "k_tmpl_start_load_page";
        public static String Ozt = "k_tmpl_page_info";
        public static String Ozu = "k_tmpl_data_key";
        public static String Ozv = "k_tmpl_session_id";
        public static String Ozw = "k_tmpl_scene";
        public static String Ozx = "k_tmpl_sub_scene";
        public static String Ozy = "k_tmpl_is_webview_prc_created";
        public static String Ozz = "k_tmpl_orig_prc_pid";

        private p() {
        }

        static {
            AppMethodBeat.i(205106);
            AppMethodBeat.o(205106);
        }
    }

    public static final class a {
        public static int akL(int i2) {
            switch (i2) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                default:
                    return 0;
            }
        }
    }

    public static final class j {
        private j() {
        }
    }

    /* renamed from: com.tencent.mm.ui.e$e  reason: collision with other inner class name */
    public static final class C2115e {
        public static final String OyU = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect");
        public static final String OyV = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/infringement?url=%s#wechat_redirect");
        public static final String OyW = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=weixin_report/w_type&scene=60");

        static {
            AppMethodBeat.i(205101);
            AppMethodBeat.o(205101);
        }
    }

    public static final class g {
        public static final String Ozb = (com.tencent.mm.loader.j.b.aKJ() + "switchAccountBg");

        static {
            AppMethodBeat.i(141282);
            AppMethodBeat.o(141282);
        }
    }

    public static String avA(String str) {
        AppMethodBeat.i(141283);
        String str2 = str + "_" + System.currentTimeMillis();
        AppMethodBeat.o(141283);
        return str2;
    }

    public interface f {

        public enum a {
            SUCCESS,
            FAIL,
            CANCEL;

            public static a valueOf(String str) {
                AppMethodBeat.i(205103);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(205103);
                return aVar;
            }

            static {
                AppMethodBeat.i(205104);
                AppMethodBeat.o(205104);
            }
        }
    }
}
