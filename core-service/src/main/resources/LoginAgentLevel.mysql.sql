CREATE FUNCTION `LoginAgentLevel`(
  id BIGINT
)
  RETURNS INT(11) DETERMINISTIC _LoginAgentLevel: BEGIN DECLARE result INT(11);
  SET @result = -1;
  SELECT min(`LEVEL`)
  INTO result
  FROM `agentLevel`
  WHERE `LOGIN_ID` = id;
  IF (result >= 0)
  THEN RETURN result;
    LEAVE _LoginAgentLevel; END IF;
  SET @result = -1;
  SELECT COUNT(`id`)
  INTO result
  FROM `MainOrder`
  WHERE `ORDERBY_ID` = id AND `ORDERSTATUS` IN (2, 3, 4, 5);
  IF (result > 0)
  THEN RETURN 100;
  ELSE RETURN 200; END IF;
END