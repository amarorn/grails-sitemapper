/*
 * Copyright 2010 Kim A. Betti, Alexey Zhokhov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugins.sitemapper.impl;

import grails.plugins.sitemapper.Sitemapper;

/**
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
public abstract class PaginationSitemapper implements Sitemapper {

    private Integer pageIndex;

    public abstract Integer getPerPageCount();

    public abstract Long getTotalCount();

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPagesCount() {
        return (int) Math.ceil((double) getTotalCount() / getPerPageCount());
    }

    public Integer getOffset() {
        return pageIndex * getPerPageCount();
    }

    protected void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

}
