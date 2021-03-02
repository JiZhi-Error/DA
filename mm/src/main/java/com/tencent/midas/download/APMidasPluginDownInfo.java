package com.tencent.midas.download;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APMidasPluginDownInfo {
    public String diff_md5;
    public String down_url;
    public String full_url;
    public int fullsize;
    public boolean is_force;
    public boolean is_split;
    public String name;
    public String new_md5_decode;
    public String new_md5_encode;
    public String old_md5;
    public int size;
    public String split_download_url;
    public int update_version;

    public APMidasPluginDownInfo() {
        this.is_split = false;
        this.is_force = false;
        this.new_md5_encode = "";
        this.new_md5_decode = "";
        this.name = "";
        this.size = 0;
        this.fullsize = 0;
        this.down_url = "";
        this.full_url = "";
        this.is_split = false;
        this.is_force = false;
        this.old_md5 = "";
        this.diff_md5 = "";
        this.update_version = 0;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(193244);
        if (obj == null) {
            AppMethodBeat.o(193244);
            return false;
        } else if (!(obj instanceof APMidasPluginDownInfo)) {
            AppMethodBeat.o(193244);
            return false;
        } else {
            boolean equals = this.name.equals(((APMidasPluginDownInfo) obj).name);
            AppMethodBeat.o(193244);
            return equals;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(193245);
        if (this.name == null) {
            AppMethodBeat.o(193245);
            return 0;
        }
        int hashCode = this.name.hashCode();
        AppMethodBeat.o(193245);
        return hashCode;
    }
}
