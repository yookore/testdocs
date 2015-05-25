Test Cases

#Sign Up/Create Account#

**Input Test Data**
1.firstname: John
2.lastname: Baptist
3.email: john@yookos.com
4.country: Egypt
5.dob: 1979/05/17
6.cellphone: +278497
7.gender: Male
8.password: password

**Steps**
1. creates account

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497
———————————————————————————————————————————————————————

#User Exists#

**Input Test Data** 1. email: john@yookos.com

**Steps** 1. Checks if the user exists.

**Expected output** 1. email: john@yookos.com 2. firstname: John 3. lastname: Baptist
———————————————————————————————————————————————————————

#Get list of friends#

**Input Test Data** 1. username: johnbap 2. filter: all

**Steps** 1. Gets a list of friends.

**Expected output** 1. list: list of friends 2. username: johnbap 3. friendaccount:
———————————————————————————————————————————————————————

#Accept Friend#

**Input Test Data** 1. username: johnbap 2. targetUsername: ginald

**Steps** 1. Accepts a friend.
**Expected output** 1. username: johnbap 3. status: accepted
———————————————————————————————————————————————————————
#Reject Friend#

**Input Test Data** 1. username: johnbap 2. targetUsername: ginald

**Steps** 1. Accepts a friend.

**Expected output** 1. username: johnbap 3. status: rejected
———————————————————————————————————————————————————————

#Native Login#

**Input Test Data**  1. email: john@yookos.com  2. password: password

**Steps** 1. Native Login

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497 5. username: johnbap 6. profileimageurl: https://profileimageurl
———————————————————————————————————————————————————————

#Post Blog#

**Input Test Data**  1. username: johnbap  2. title: Apostle  3. text: This is a blog post text  4. tags: #myblog  5. mention: @ginald  6. photo: photoUrl  7. videos: videoUrl  8. audio: audioUrl

**Steps** 1. Posts blog

**Expected output**  1. username: johnbap  2. title: Apostle  3. text: This is a blog post text  4. tags: #myblog  5. mention: @ginald  6. photo: photoUrl  7. videos: videoUrl  8. audio: audioUrl
———————————————————————————————————————————————————————

#Get Blog#

**Input Test Data**  1. postid: postid

**Steps** 1. Gets blog

**Expected output**  1. blogpostid: posted  2. text: Blog text here  3. actor: firstname: John lastname: Baptist profilepicthure: imgurl  4. creation date: 17/05/2015  5. modificationdate: 17/05/2015  6. comments: link: https://commentlink, action:remove, firstname:John, lastname:Baptist, 			profilepic:imgUrl, creationdate:17/05/2015, username:johnbap,
 7. like: link: https://likelink, action:unlike, firstname:John, lastname:Baptist   8. commentcount: 23  9. likecount: 44 10. viewcount: 56 11. mentions: profilelink:https://profile/johnbap, firstname:John, lastname:Baptist 12. tag: #john 13. attachment: attachUrl
———————————————————————————————————————————————————————

#Post Audio#

**Input Test Data**  1. username: johnap  2. caption: Photo caption  3. audioData

**Steps** 1. Posts Audio

**Expected output**  1. caption: Photo caption
———————————————————————————————————————————————————————

#Get Audio Post#

**Input Test Data**  1. audioId: audioId

**Steps** 1. Gets audio post

**Expected output**  1. audio: posted  2. text: audio text here  3. title: audio title here  4. actor: firstname: John, lastname: Baptist, profilepicthure: imgurl  5. creation date: 17/05/2015  6. modificationdate: 17/05/2015  7. comments: link: https://commentlink, action:remove, firstname:John, lastname:Baptist, 			profilepic:imgUrl, creationdate:17/05/2015, username:johnbap,
 8. like: link: https://likelink, action:unlike, firstname:John, lastname:Baptist   9. commentcount: 23  10. likecount: 44 11. viewcount: 56 12. mentions: profilelink:https://profile/johnbap, firstname:John, lastname:Baptist 13. tag: #john 
———————————————————————————————————————————————————————

#Post Status#

**Input Test Data**  1. username: johnbap  2. text: This is a status Update Text  3. mention: @ginald  4. photo: photoUrl  5. videos: videoUrl  6. location: Randburg

**Steps** 1. Posts a status message

**Expected output**  1. username: johnbap  2. text: This is a blog post text
———————————————————————————————————————————————————————

#Get Status Update#

**Input Test Data**  1. statusupdateid: statusId

**Steps** 1. Gets Status Message

**Expected output**  1. statusupdateid: statusId  2. text: audio text here  3. actor: firstname: John, lastname: Baptist, profilepicthure: imgurl  4. creation date: 17/05/2015  5. modificationdate: 17/05/2015  6. comments: link: https://commentlink, action:remove, firstname:John, lastname:Baptist, 			profilepic:imgUrl, creationdate:17/05/2015, username:johnbap,
 7. like: link: https://likelink, action:unlike, firstname:John, lastname:Baptist   8. commentcount: 23  9. likecount: 44 10. viewcount: 56 11. mentions: profilelink:https://profile/johnbap, firstname:John, lastname:Baptist 12. tag: #john 13. attachment: attachUrl
———————————————————————————————————————————————————————

#Update Profile Native#

**Input Test Data**  1. currentCity: Egypt City  2. homeCountry: Egypt  3. homeTown: Galilee  4. relationshipStatus: Single  5. interests: Jesus

**Steps** 1. Updates Profile Native

**Expected output**  1. userid: 23  2. sessionid: 321 ———————————————————————————————————————————————————————

#Update Profile Responsive Web#

**Input Test Data**  1. email: john@yookos.com  2. dob: 1950/05/17  3. relationshipstatus: single  4. currentcountry: Egypt  5. biography: Jesus’s deciple  6. cellphone: +278497  7. firstname: John  8. lastname: Baptist  9. gender: Male  10. alternativeemail: john@gmail.com  11. homecountry: Egypt  12. timezone: Africa  13. imageurl: https://imageurl  14. title: Apostle  15. lastupdated: 17/05/2015  16. hometown: Galilee  17. currentcity: Egypt City  18. username: johnbap  19. interests: Jesus

**Steps** 1. Updates Profile Responsive Web

**Expected output**  1. userid: 23  2. sessionid: 321
———————————————————————————————————————————————————————

#Post profile picture#

**Input Test Data**  1. imageUrl: imgUrl  2. username: johnbap

**Steps** 1. Gets the profile pic image

**Expected output**  1. userid: 23  2. sessionid: 321
———————————————————————————————————————————————————————

#Gets profile#

**Input Test Data**  1. username: johnbap

**Steps** 1. Gets Profile data

**Expected output**  1. email: john@yookos.com  2. dob: 1950/05/17  3. relationshipstatus: single  4. currentcountry: Egypt  5. biography: Jesus’s deciple  6. cellphone: +278497  7. firstname: John  8. lastname: Baptist  9. gender: Male  10. alternativeemail: john@gmail.com  11. homecountry: Egypt  12. timezone: Africa  13. imageurl: https://imageurl  14. title: Apostle  15. lastupdated: 17/05/2015  16. hometown: Galilee  17. currentcity: Egypt City  18. username: johnbap  19. interests: Jesus
———————————————————————————————————————————————————————

#Sign Up/Create Account Social#

**Input Test Data**  1. firstname:  John  2. lastname:  Baptist  3. email: john@yookos.com  4. country: Egypt  5. dob: 1979/05/17  6. cellphone: +278497  7. gender: Male  8. password: password  9. verified: false  10. locale: GMT+2  11. timezone: 2  12. updated: 17/05/2015  13. fullnames: John Baptist

**Steps** 1. creates account Social

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497
———————————————————————————————————————————————————————

#Social Login#

**Input Test Data**  1. socialProviderEmail: john@yookos.com  2. password: password

**Steps** 1. Social Login

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497 5. username: johnbap 6. profileimageurl: https://profileimageurl
———————————————————————————————————————————————————————

#Sms verify User#

**Input Test Data**  1. verificationCode: verif123

**Steps** 1. Sms verify user

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497 5. username: johnbap 6. country: Egypt 7. verified: true
———————————————————————————————————————————————————————

#Email verify User#

**Input Test Data**  1. verificationCode: verif123

**Steps** 1. Email verify user

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497 5. username: johnbap 6. country: Egypt 7. verified: true
———————————————————————————————————————————————————————

#Email verify access Token#

**Input Test Data**  1. userId: johnbap  2. password: password

**Steps** 1. Email verify with access Token

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. access_token: 123 4. clients: 213 5. refresh_token: 312
———————————————————————————————————————————————————————

#Email phone verify User#

**Input Test Data**  1. email: john@yookos.com  2. +278497

**Steps** 1. Email phone verify user

**Expected output** 1. firstname:  John 2. lastname:  Baptist 3. email: john@yookos.com 4. cellphone: +278497 5. username: johnbap 6. country: Egypt 7. verified: true