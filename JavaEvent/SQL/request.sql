SELECT Creators.creator_type, Users.creator_type, Organization.creator_type from Events JOIN Creators USING (creator_id) LEFT JOIN Users USING (creator_id) LEFT JOIN Organization USING (creator_id);
