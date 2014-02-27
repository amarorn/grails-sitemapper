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
package demo

import grails.plugins.sitemapper.ContentChangeFrequency
import grails.plugins.sitemapper.EntryWriter
import grails.plugins.sitemapper.impl.PaginationSitemapper

/**
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
class ArticlesSitemapper extends PaginationSitemapper {

    Date previousUpdate = new Date()

    final Integer perPageCount = 40
    final Long totalCount = 100

    @Override
    public void withEntryWriter(EntryWriter entryWriter) {
        switch (pageIndex) {
            case 0:
                1.times { n ->
                    entryWriter.addEntry "/articles/${n}", new Date() - 1
                }

                break;

            case 1:
                2.times { n ->
                    entryWriter.addEntry "/articles/${n}", new Date(), ContentChangeFrequency.MONTHLY, 0.5
                }
                break;

            case 2:
                3.times { n ->
                    entryWriter.addEntry "/articles/${n}", new Date(), ContentChangeFrequency.DAILY, 0.6
                }
                break;
        }
    }

}
