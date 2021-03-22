/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  LIM
 * Created: Mar 21, 2021
 */

INSERT INTO train (id, name, description, distance_between_stop, max_speed, sharing_tracks, grade_crossing, train_frequency, amenities)
VALUES(
    1,
    'Light rail',
    'Light rail, which might be also known as trolley and streetcars, mean trains that function as local transit in an urban-core and can operate on the street-level. Compared to rapid transit, light rail costs less, is more pedestrian friendly, but has less passenger capacity. The major advantage with light rail is that it can operate like rapid transit or like local buses, depending on the available infrastructure',
    'a few blocks to 1 or 2 miles',
    '55-65 mph',
    true,
    false,
    '3-30 minutes',
    'n/a'
);

INSERT INTO train (id, name, description, distance_between_stop, max_speed, sharing_tracks, grade_crossing, train_frequency, amenities)
VALUES(
    2,
    'Rapid transit',
    'Rapid transit, which is also known as metro, subway, and heavy rail, mean trains that generally serve the urban-core, have large passenger capacity, and operate totally separate from road traffic. In order to run separately from road traffic in the city-core, rapid transit trains would run either above or underground.',
    '1/2 mile to 2 or 3 miles',
    '65-70 mph',
    false,
    false,
    '3-20 minutes',
    'Large space for standees'
);

INSERT INTO train (id, name, description, distance_between_stop, max_speed, sharing_tracks, grade_crossing, train_frequency, amenities)
VALUES(
    3,
    'Commuter rail',
    'Commuter trains generally mean trains connecting suburban areas with the central city and primarily serves riders to and from work. Commuter trains typically run on weekdays, during rush hours, and only in the peak directions.',
    '1 to 2 miles',
    '79 mph',
    true,
    true,
    '15 minutes to hourly (some operate only during weekday peak hours)',
    'Restroom'
);

INSERT INTO train (id, name, description, distance_between_stop, max_speed, sharing_tracks, grade_crossing, train_frequency, amenities)
VALUES(
    4,
    'Inter-city rail',
    'Inter-city trains generally mean trains traveling long distances connecting metropolitan areas. Although the distances covered by some of these trains are comparable to airlines, inter-city trains generally operate at highway speed. Long distance inter-city trains may provide amenities not found on most other forms of transportation, including sleeper-cars and cafe/dining cars.',
    '2 to 10 miles',
    '79 mph',
    true,
    true,
    'Hourly to once a day, or even three trips a week.',
    'Restroom, business class, sleeper (longer distance), cafe car, dining car'
);

INSERT INTO train (id, name, description, distance_between_stop, max_speed, sharing_tracks, grade_crossing, train_frequency, amenities)
VALUES(
    5,
    'High speed rail',
    'High speed trains are generally defined as trains that can operate 125mph or faster. High speed trains generally connect large metropolitan areas (with very few stops in between) and are meant to be competitive with airlines in terms of overall travel time.',
    'at least 10 miles',
    'at least 90 mph',
    false,
    false,
    '15 minutes to hourly',
    'Restroom, business class, cafe car'
);