package ibf2023.csf.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import ibf2023.csf.backend.models.PhotoDetails;

@Repository
public class PictureRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	// TODO Task 4.2
	// You may change the method signature by adding parameters and/or the  return type
	// You may throw any exception 

	
// db.comments.aggregate([
// 	{$group: {
// 		_id: "$rating",
// 		count: { $sum: 1 },
// 		users: { $push: "$user" }
// 		}
// 	}
// 	,{ $sort: { count: -1 }
// 	}
// 	]);

	public boolean save(PhotoDetails photo, MultipartFile file) {

	
		mongoTemplate.save(photo, "travelpics");
		return true;
 
	}
}

// 		GroupOperation groupByRated= Aggregation.group(“rated”)
//                                                                 .push(“title”).as(“titles”)
//                                                                 .count().as(“count”);
// SortOperation sortByCount= Aggregation.sort(
//                      Sort.by(Direction.ASC, “count”));
// Aggregation pipeline= Aggregation.newAggregation(
//                    groupByRated, sortByCount);
// AggregationResults<Document> results=
//                     mongoTemplate.aggregate(
//                               pipeline, “movies”, Document.class);
// 	}

//    public List<AggregateRSVP> aggregateRSVPByFoodType(){
//         List<AggregateRSVP> aggregateRSVPs = new LinkedList<>();
//         // System.out.println("+++++++++" + restAPIendpoint);
//         GroupOperation grpByFoodTypeOpr = Aggregation
//                     .group("foodType")
//                     .push("foodType").as("foodType")
//                     .count().as("count");
            
//         SortOperation sortByCount = Aggregation.sort(
//                     Sort.by(Direction.DESC, "count")); 
                    
//         Aggregation pipeline = Aggregation.newAggregation(grpByFoodTypeOpr, sortByCount);
//         AggregationResults results = mongoTemplate.aggregate(pipeline, "rsvp", Document.class);
        
//         Iterator<Document> cursor = results.iterator();
//         while(cursor.hasNext()){
//             Document doc = cursor.next();
//             aggregateRSVPs.add(AggregateRSVP.create(doc));
//         }
//         return aggregateRSVPs;
//     }
