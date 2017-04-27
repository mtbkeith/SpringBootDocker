/*
 * Copyright 2017
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
package us.xwhite.dvd.db;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import us.xwhite.dvd.domain.InventorySummary;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
public interface InventorySummaryRepository extends Repository<InventorySummary, String> {
 
    @Query("select new InventorySummary(f.title, c.name, count(*)) from Film f join f.inventoryCollection i join f.filmCategoryCollection fc join fc.category c left join i.rentalCollection r with r.returnDate is null where i.storeId.storeId = :storeId and r.inventoryId is null group by f.title, c.name")
    public List<InventorySummary> findAllInStockAtStore(@Param("storeId") Long storeId);
}