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

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import us.xwhite.dvd.domain.CustomerSummary;
import us.xwhite.dvd.domain.base.Customer;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
public interface CustomerRepository extends Repository<Customer, Short> {

    @Query("select new CustomerSummary(c.email, c.firstName, c.lastName) from Customer c where c.email = ?#{principal.username}")
    public CustomerSummary findOneSummaryByAuthenticatedUser();
    
    @Query("select c from Customer c where c.email = ?#{principal.username}")
    public Customer findOneByAuthenticatedUser();
}
