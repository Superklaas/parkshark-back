alter table parking_lot
    add available_spots_left integer
        check (available_spots_left >= 0);
