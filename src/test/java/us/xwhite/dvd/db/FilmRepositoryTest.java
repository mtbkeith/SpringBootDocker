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

import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import us.xwhite.dvd.domain.base.Film;
import us.xwhite.dvd.domain.base.Inventory;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
public class FilmRepositoryTest {
    
    @Autowired
    private FilmRepository filmRepository;

    @Test
    @Transactional
    public void findAll() {
        String filmTitle = "ACADEMY DINOSAUR";
        Film film = filmRepository.findOneByName(filmTitle);
        Assert.assertNotNull(film);
        Assert.assertEquals(filmTitle, film.getTitle());
    }
    
    @Test
    @Transactional
    public void findFilmIdToRent() {
        Inventory inventory = filmRepository.findFilmByStoreAndNameForRental(1L, "ACADEMY DINOSAUR");
        Assert.assertNotNull(inventory);
        Assert.assertEquals(7, inventory.getInventoryId().intValue());
        inventory = filmRepository.findFilmByStoreAndNameForRental(1L, "ACE GOLDFINGER");
        Assert.assertNotNull(inventory);
        Assert.assertEquals(8, inventory.getInventoryId().intValue());
    }
}
