
package com.example.consocio.bibliospaz.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Can {

    @SerializedName("create")
    @Expose
    private Boolean create;
    @SerializedName("edit")
    @Expose
    private Boolean edit;
    @SerializedName("delete")
    @Expose
    private Boolean delete;

    public Boolean getCreate() {
        return create;
    }

    public void setCreate(Boolean create) {
        this.create = create;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

}
