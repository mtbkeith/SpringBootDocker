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

import us.xwhite.dvd.domain.StoreSummary;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
public interface StoreSummaryRepository extends Repository<StoreSummary, String> {

    @Query("select new StoreSummary(s.storeId, a.address, a.address2, a.district, a.phone, c.city, co.country) "
            + "from Address a join a.storeCollection s join a.cityId c join c.countryId co")
    public List<StoreSummary> findAll();
}
